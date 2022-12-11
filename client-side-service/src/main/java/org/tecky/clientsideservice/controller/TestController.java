package org.tecky.clientsideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.mapper.CategoryDetailEntityRepository;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;
import org.tecky.clientsideservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    ICategoryService iCategoryService;


    @GetMapping("/test")
    public String getTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<CategoryDTO> categoryDTOList = iCategoryService.getCategory("ABCDE");

        return "test";

    }
}
