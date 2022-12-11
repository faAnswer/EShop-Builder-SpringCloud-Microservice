package org.tecky.clientsideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.mapper.CategoryEntityRepository;
import org.tecky.clientsideservice.mapper.LayoutEntityRepository;

@RestController
public class TestController {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;


    @GetMapping("/test")
    public String getTest(){

        categoryEntityRepository.findByClientId("ABCDE");


        return "test";

    }
}
