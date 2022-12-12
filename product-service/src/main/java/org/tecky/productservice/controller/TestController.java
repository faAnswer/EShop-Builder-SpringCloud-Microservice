package org.tecky.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.productservice.entities.TypeEntity;
import org.tecky.productservice.mapper.TypeEntityRepository;
import org.tecky.productservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    TypeEntityRepository typeEntityRepository;


    @GetMapping("/test")
    public String getTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<TypeEntity> categoryDTOList = typeEntityRepository.findAllValidType();

        return "test";

    }
}
