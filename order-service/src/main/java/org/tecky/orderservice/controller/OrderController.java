package org.tecky.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostOrderDTO;

@RestController
@RequestMapping("/api")
public class OrderController {

    @PostMapping("/v1/order")
    public ResponseEntity<?> postOrder(PostOrderDTO postOrderDTO){

        ResponseEntity<?> res;





    }


}