package org.tecky.orderservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostOrderDTO;
import org.tecky.orderservice.service.intf.IOrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @PostMapping("/v1/order")
    public ResponseEntity<?> postOrder(@Validated @RequestBody PostOrderDTO postOrderDTO){

        ResponseEntity<?> res;

        try {

            res = iOrderService.createOrder(postOrderDTO);

        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error POST/api/v1/order" + "\n" + e.getMessage());
        }

        return res;
    }


}
