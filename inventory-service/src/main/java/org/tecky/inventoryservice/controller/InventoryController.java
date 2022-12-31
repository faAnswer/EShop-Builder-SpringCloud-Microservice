package org.tecky.inventoryservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.CategoryTypeDTO;
import org.tecky.common.dto.PostInventoryDTO;
import org.tecky.inventoryservice.mapper.InventoryEntityRepository;
import org.tecky.inventoryservice.service.intf.InventoryService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/v1/inventory", consumes = "application/json")
    public ResponseEntity<?> postInventory(@RequestBody @Validated PostInventoryDTO postInventoryDTO){

        ResponseEntity<?> res;

        try {

            res = inventoryService.createInventory(postInventoryDTO);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "" + "\n" + e.getMessage());
        }

        return res;
    }
}
