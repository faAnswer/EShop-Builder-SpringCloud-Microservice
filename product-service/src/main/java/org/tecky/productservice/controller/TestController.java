package org.tecky.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.productservice.entities.TypeEntity;
import org.tecky.productservice.mapper.CategoryDetailEntityRepository;
import org.tecky.productservice.mapper.ProductDetailEntityRepository;
import org.tecky.productservice.mapper.TypeEntityRepository;
import org.tecky.productservice.service.CategoryChecker;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    ProductDetailEntityRepository productDetailEntityRepository;

    @GetMapping("/v1/test")
    public String getTest()  {


        return "test";

    }
}
