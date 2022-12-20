package org.tecky.couponservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.config.KafkaTopicConfig;
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

    @GetMapping("/v1/kafka")
    public String post() {


        kafkaTemplate.send(KafkaTopicConfig.COUPON, "123");

        return "Published done";
    }

    @KafkaListener(topics = KafkaTopicConfig.COUPON, groupId = KafkaConfig.GROUP_1)
    public void consume(String message) {

        log.info(message);
    }
}
