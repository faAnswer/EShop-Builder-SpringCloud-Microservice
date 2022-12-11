package org.tecky.clientsideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.mapper.CategoryDetailEntityRepository;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;

@RestController
public class TestController {

    @Autowired
    CategoryDetailEntityRepository categoryDetailEntityRepository;


    @GetMapping("/test")
    public String getTest(){

        categoryDetailEntityRepository.findAllCategoryByClientId("ABCDE");

        return "test";

    }
}
