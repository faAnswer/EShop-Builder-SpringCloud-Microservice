package org.tecky.productservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.dto.PostGroupDTO;


@RestController
@RequestMapping("/api")
public class ProductGroupController {

    @PostMapping(value = "/v1/group", consumes = "application/json")
    public String postGroup(@RequestBody @Validated PostGroupDTO postGroupDTO){




        return "OK";


    }

}
