package org.tecky.uuaservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tecky.uuaservice.mapper.UserEntityRepository;

public class CustomUserDetailsService  {

//    @Autowired
//    UserEntityRepository userEntityRepository;
//
//    private String clientId;
//
//    public void setClientId(String clientId){
//
//        this.clientId = clientId;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user;
//
//
//
//
//
//
//
//
//        return user;
//    }
}
