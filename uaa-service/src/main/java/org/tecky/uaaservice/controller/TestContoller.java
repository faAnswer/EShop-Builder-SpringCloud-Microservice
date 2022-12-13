package org.tecky.uaaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.tecky.uaaservice.entities.OauthClientEntity;
import org.tecky.uaaservice.mapper.OauthClientEntityRepository;
import org.tecky.uaaservice.services.FetchClientScrect;

import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class TestContoller {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    FetchClientScrect fetchClientScrect;


    @Autowired
    OauthClientEntityRepository oauthClientEntityRepository;


    @GetMapping("/test")
    public String gotest() {


        return "test";
    }

    @GetMapping("/fetch")
    public String gotest2() throws Exception {

        fetchClientScrect.fetch();

        return "fetch success";
    }
}
