package org.tecky.productservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.dto.PostGroupDTO;
import org.tecky.common.dto.PostProductDTO;
import org.tecky.productservice.service.intf.IProductService;


@RestController
@RequestMapping("/api")
public class ProductGroupController {
    @Autowired
    IProductService iProductService;

    @PostMapping(value = "/v1/products", consumes = "application/json")
    public ResponseEntity<?> postGroup(@RequestBody @Validated PostGroupDTO postGroupDTO){

        ResponseEntity<?> response;

        try {

            response = iProductService.insertProductGroup(postGroupDTO);
        } catch (Exception e) {

            throw new CustomException(500, "Error POST/api/v1/products" + e.getMessage());
        }

        return response;
    }
    @PostMapping(value = "/v1/product", consumes = "application/json")
    public ResponseEntity<?> postProduct(@RequestBody @Validated PostProductDTO postProductDTO){

        ResponseEntity<?> response;

        try {

            response = iProductService.insertProduct(postProductDTO);
        } catch (Exception e) {

            throw new CustomException(500, "Error POST/api/v1/product" + e.getMessage());
        }

        return response;
    }

    @GetMapping(value = "/v1/products")
    public ResponseEntity<?> getProduct(@RequestParam("groupId") Integer groupId){

        ResponseEntity<?> response;

        try {

            response = iProductService.findProductGroup(groupId);
        } catch (Exception e) {

            throw new CustomException(500, "Error GET/api/v1/products" + e.getMessage());
        }

        return response;
    }
}
