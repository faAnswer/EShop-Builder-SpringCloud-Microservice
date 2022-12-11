package org.tecky.clientsideservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @GetMapping("/v1/category")
    public String getCategory(@PathParam("client_id") HttpServletRequest request, HttpServletResponse response){






        return "category";
    }
}
