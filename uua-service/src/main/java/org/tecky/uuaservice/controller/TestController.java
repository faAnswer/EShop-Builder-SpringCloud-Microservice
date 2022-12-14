package org.tecky.uuaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.mapper.ClientSecUserEntityRepository;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    ClientSecUserEntityRepository clientSecUserEntityRepository;

    @GetMapping("/v1/test")
    public String getTest(){

        clientSecUserEntityRepository.findByClientIdAndEmail("admin", "Admin@Admin.com");
        return "test";
    }
}
