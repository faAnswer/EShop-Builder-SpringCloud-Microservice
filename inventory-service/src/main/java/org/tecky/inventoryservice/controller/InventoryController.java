package org.tecky.inventoryservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.api.inventoryservice.InventoryAPI;
import org.tecky.common.dto.PostInventoryDTO;
import org.tecky.inventoryservice.service.intf.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController implements InventoryAPI {

    @Autowired
    InventoryService inventoryService;

    @Override
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

    @Override
    @GetMapping(value = "/v1/qty", params = {"productId"})
    public ResponseEntity<?> getQty(@RequestParam("productId") Integer productId) {

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
    @Override
    @GetMapping(value = "/v1/records", params = {"inventoryId"})
    public ResponseEntity<?> getRecords(@RequestParam("inventoryId") Integer inventoryId) {

        ResponseEntity<?> res;

        try {

            res = inventoryService.getRecord(inventoryId);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "/api/v1/records" + "\n" + e.getMessage());
        }

        return res;
    }
}