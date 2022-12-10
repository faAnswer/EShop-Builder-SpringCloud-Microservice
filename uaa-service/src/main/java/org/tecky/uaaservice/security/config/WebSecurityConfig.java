package org.tecky.uaaservice.security.config;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import org.tecky.uaaservice.security.filter.JwtRequestFilter;
import org.tecky.uaaservice.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(){

        var authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsServiceImpl);
        authProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authProvider);
    }



    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        log.info("FilterChain");

        http
                 .cors()
                    .and()
                 .csrf()
                    .disable()
                 .authorizeRequests()
                    .antMatchers("/fetch").permitAll()
                    .antMatchers("/index.html").permitAll()
                    .antMatchers("/index").permitAll()
                    .antMatchers("/login.html").permitAll()
                    .antMatchers("/api/user/login").permitAll()
                     .antMatchers("/api/auth/**").permitAll()
                    .antMatchers("/hello").permitAll()

                 //.antMatchers("/api/oauth/**").permitAll()
                    .antMatchers("/*.js").permitAll()
                    .antMatchers("/**/*.js").permitAll()
                    .antMatchers("/*.css").permitAll()
                    .antMatchers("/**/*.css").permitAll()
                    .antMatchers("/*.ico").permitAll()
                    .antMatchers("/**/*.ico").permitAll()
                    .antMatchers("/*.jpg").permitAll()
                    .antMatchers("/**/*.jpg").permitAll()
                    .anyRequest().authenticated();


        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}