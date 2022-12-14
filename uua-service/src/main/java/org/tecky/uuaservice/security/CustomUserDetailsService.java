package org.tecky.uuaservice.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.mapper.ClientSecUserEntityRepository;

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    ClientSecUserEntityRepository clientSecUserEntityRepository;

    private String clientId;

    public void setClientId(String clientId){

        this.clientId = clientId;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user;

        ClientSecUserEntity clientSecUserEntity = clientSecUserEntityRepository.findByClientIdAndEmail(this.clientId, email);

        Integer roleId = clientSecUserEntity.getRoleId();








        return user;
    }
}
