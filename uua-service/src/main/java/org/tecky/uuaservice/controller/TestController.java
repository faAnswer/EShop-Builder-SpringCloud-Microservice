package org.tecky.uuaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.uuaservice.entities.UserSecClientEntity;
import org.tecky.uuaservice.mapper.UserSecClientEntityRepository;

@RestController
public class TestController {

    @Autowired
    UserSecClientEntityRepository userSecClientEntityRepository;
    @GetMapping("/test")
    public String getTest(){

        UserSecClientEntity userSecClientEntity = new UserSecClientEntity();

        userSecClientEntity.setClientName("TestABC");
        userSecClientEntity.setUsername("abcdefg");




        return "test";
    }
}
