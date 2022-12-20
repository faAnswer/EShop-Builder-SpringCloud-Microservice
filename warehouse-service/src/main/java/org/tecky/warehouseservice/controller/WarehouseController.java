package org.tecky.warehouseservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostWarehouseDTO;
import org.tecky.warehouseservice.service.intf.IWarehouseService;

@RestController
@RequestMapping("/api")
public class WarehouseController {

    @Autowired
    IWarehouseService iWarehouseService;

    @PostMapping(value = "/v1/warehouse", consumes = "application/json")
    public ResponseEntity<?> createWarehouse(@Validated @RequestBody PostWarehouseDTO postWarehouseDTO){

        ResponseEntity<?> res;

        try {

            res = iWarehouseService.createWarehouse(postWarehouseDTO);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error POST/api/v1/warehouse" + "\n" + e.getMessage());
        }

        return res;
    }

}
