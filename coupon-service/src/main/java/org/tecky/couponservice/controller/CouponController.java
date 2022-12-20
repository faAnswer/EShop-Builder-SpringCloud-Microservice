package org.tecky.couponservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostCouponDTO;
import org.tecky.couponservice.service.intf.ICouponService;

@RestController
@RequestMapping("/api")
public class CouponController {

    @Autowired
    ICouponService iCouponService;

    @PostMapping("/v1/coupons")
    public ResponseEntity<?> createCoupon(@Validated @RequestBody PostCouponDTO postCouponDTO){

        ResponseEntity<?> res;

        try {

            res = iCouponService.createCoupon(postCouponDTO);
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
