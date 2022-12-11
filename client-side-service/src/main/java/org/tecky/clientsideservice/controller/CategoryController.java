package org.tecky.clientsideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    TypeListEntityRepository typeListEntityRepository;

    @GetMapping("/v1/category")
    public String getCategory(@PathParam("clientId") String clienId, HttpServletRequest request, HttpServletResponse response){










        return "category";
    }
}
