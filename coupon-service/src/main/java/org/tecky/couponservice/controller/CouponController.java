package org.tecky.couponservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.config.KafkaTopicConfig;
import org.tecky.common.dto.PatchCouponDTO;
import org.tecky.common.dto.PostCouponDTO;
import org.tecky.couponservice.config.KafkaConfig;
import org.tecky.couponservice.service.intf.ICouponService;

@RestController
@RequestMapping("/api")
@Slf4j
public class CouponController {

    @Autowired
    ICouponService iCouponService;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping(value = "/v1/coupon", consumes = "application/json")
    public ResponseEntity<?> createCoupon(@Validated @RequestBody PostCouponDTO postCouponDTO){

        ResponseEntity<?> res;

        try {

            res = iCouponService.createCoupon(postCouponDTO);
        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error POST/api/v1/coupon" + "\n" + e.getMessage());
        }

        kafkaTemplate.send(KafkaTopicConfig.COUPON, postCouponDTO);

        return res;
    }

    @GetMapping("/v1/discount")
    public ResponseEntity<?> getDiscount(PatchCouponDTO patchCouponDTO){

        ResponseEntity<?> res;

        try {

            res = iCouponService.getCouponDiscount(patchCouponDTO);
        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error GET/api/v1/discount" + "\n" + e.getMessage());
        }

        return res;
    }

    @PatchMapping(value = "/v1/coupon", consumes = "application/json")
    public ResponseEntity<?> patchCoupon(PatchCouponDTO patchCouponDTO){

        ResponseEntity<?> res;

        try {

            res = iCouponService.patchCoupon(patchCouponDTO);
        } catch (Exception e) {

            Integer httpCode = 500;

            if (e instanceof CustomException) {

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error PATCH/api/v1/coupon" + "\n" + e.getMessage());
        }

        return res;
    }
}
