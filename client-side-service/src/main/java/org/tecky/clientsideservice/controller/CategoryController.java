package org.tecky.clientsideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.entities.CategoryEntity;
import org.tecky.clientsideservice.mapper.CategoryEntityRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @GetMapping("/v1/category")
    public String getCategory(@PathParam("client_id") HttpServletRequest request, HttpServletResponse response){






        return "category";
    }
}
