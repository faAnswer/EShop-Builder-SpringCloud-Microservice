package org.tecky.uuaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.uuaservice.mapper.RoleAuthEntityRepository;
import org.tecky.uuaservice.mapper.RoleAuthS2OScopeEntityRepository;

@RestController
@RequestMapping("/api")
public class TestController {



    @Autowired
    RoleAuthS2OScopeEntityRepository roleAuthS2OScopeEntityRepository;
    @Autowired
    RoleAuthEntityRepository roleAuthEntityRepository;
    @GetMapping("/v1/test")
    public String getTest(){



        return "test";
    }
}
