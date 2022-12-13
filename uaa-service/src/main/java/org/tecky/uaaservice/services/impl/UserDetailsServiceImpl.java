package org.tecky.uaaservice.services.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tecky.uaaservice.entities.UserEntity;
import org.tecky.uaaservice.entities.UserRoleEntity;
import org.tecky.uaaservice.mapper.RoleEntityRespository;
import org.tecky.uaaservice.mapper.UserEntityRepository;
import org.tecky.uaaservice.mapper.UserRoleEntityRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRoleEntityRepository userRoleEntityRepository;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    RoleEntityRespository roleEntityRespository;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        if(httpServletRequest.getHeader("client_id") == null) {

            throw new CustomException(403, "Client ID is required in headers");
        }

        UserEntity userEntity = userEntityRepository.findByUsernameAndClientId(username, httpServletRequest.getHeader("client_id"));

        if(userEntity == null) {

            throw new UsernameNotFoundException(username);
        }

        List<UserRoleEntity> userRoleEntity = userRoleEntityRepository.findByUid(userEntity.getUid());

        List<GrantedAuthority> authorities = userRoleEntity.stream()
                .map(element -> roleEntityRespository
                .findByRoleid(element.getRoleid()))
                .map(element -> new SimpleGrantedAuthority(element.getName()))
                .collect(Collectors.toList());

        User user = new User(userEntity.getUsername(), userEntity.getShapassword(), authorities);

        return user;
    }
}
