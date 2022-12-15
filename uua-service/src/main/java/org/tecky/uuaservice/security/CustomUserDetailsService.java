package org.tecky.uuaservice.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;
import org.tecky.uuaservice.mapper.ClientSecUserEntityRepository;
import org.tecky.uuaservice.mapper.RoleAuthS2OScopeEntityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    ClientSecUserEntityRepository clientSecUserEntityRepository;

    @Autowired
    RoleAuthS2OScopeEntityRepository roleAuthS2OScopeEntityRepository;

    private String clientId;

    public void setClientId(String clientId){

        this.clientId = clientId;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user;

        ClientSecUserEntity clientSecUserEntity = clientSecUserEntityRepository.findByClientIdAndEmail(this.clientId, email);

        Integer roleId = clientSecUserEntity.getRoleId();

        List<RoleAuthS2OScopeEntity> roleAuthS2OScopeEntityList = roleAuthS2OScopeEntityRepository.findByRoleId(roleId);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        for(RoleAuthS2OScopeEntity roleAuthS2OScopeEntity : roleAuthS2OScopeEntityList){

            grantedAuthorityList.add(new SimpleGrantedAuthority(roleAuthS2OScopeEntity.getScopeEntity().getScopeName()));
        }


        user = new User(String.valueOf(clientSecUserEntity.getUid()), clientSecUserEntity.getShapassword(), grantedAuthorityList);

        return user;
    }
}
