package org.tecky.inventoryservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.dto.PostInventoryDTO;
import org.tecky.inventoryservice.service.intf.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/v1/inventory", consumes = "application/json")
    public ResponseEntity<?> postInventory(@RequestBody @Validated PostInventoryDTO postInventoryDTO) {

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

    @GetMapping(value = "/v1/product", params = {"productId"})
    public ResponseEntity<?> getSummary(@RequestParam("productId") Integer productId) {

        ResponseEntity<?> res;

        try {

            res = inventoryService.getSummary(productId);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "/api/v1/product" + "\n" + e.getMessage());
        }

        return res;
    }
}