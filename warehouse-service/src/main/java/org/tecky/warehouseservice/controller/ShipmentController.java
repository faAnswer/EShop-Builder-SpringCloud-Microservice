package org.tecky.warehouseservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostWarehouseDTO;
import org.tecky.common.dto.PostWarehouseInShipmentDTO;
import org.tecky.warehouseservice.service.intf.IShipmentService;

@RestController
@RequestMapping("/api")
public class ShipmentController {

    @Autowired
    IShipmentService iShipmentService;

    @PostMapping("/v1/in")
    public ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO postWarehouseInShipmentDTO){

        ResponseEntity<?> res;

        try {

            res = iShipmentService.createInShipment(postWarehouseInShipmentDTO);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error POST/api/v1/in" + "\n" + e.getMessage());
        }

        return res;
    }
}
