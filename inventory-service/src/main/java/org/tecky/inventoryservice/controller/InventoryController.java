package org.tecky.inventoryservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.CategoryTypeDTO;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @PostMapping(value = "/v1/inventory", consumes = "application/json")
    public String inventory(@RequestBody CategoryTypeDTO bddyMap){



        return "test";

    }
}
