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

    @PostMapping("/v1/coupon")
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

        kafkaTemplate.send(KafkaTopicConfig.COUPON, postCouponDTO);

        return res;
    }

    @GetMapping("/v1/test")
    public String patchCoupon(@RequestParam PostCouponDTO postCouponDTO){



        return "OK";
    }



//    @PatchMapping("/v1/coupon")
//    public ResponseEntity<?> patchCoupon(@Validated @RequestBody PostCouponDTO postCouponDTO){
//
//
//
//
//    }

//    @KafkaListener(topics = KafkaTopicConfig.COUPON, groupId = KafkaConfig.GROUP_1)
//    public void consume(String message) throws JsonProcessingException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        PostCouponDTO postCouponDTO = objectMapper.readValue(message, PostCouponDTO.class);
//
//        KafkaTopicConfig.string2Object(message, KafkaTopicConfig.map.get(KafkaTopicConfig.COUPON));
//
//        log.info(message);
//    }

}
