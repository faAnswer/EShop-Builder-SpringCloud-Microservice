package org.tecky.couponservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostCouponDTO;
import org.tecky.couponservice.entities.CouponSecDetailEntity;
import org.tecky.couponservice.entities.CouponTypeEntity;
import org.tecky.couponservice.mapper.CouponSecDetailEntityRepository;
import org.tecky.couponservice.mapper.CouponTypeEntityRepository;
import org.tecky.couponservice.service.intf.ICouponService;

@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    CouponTypeEntityRepository couponTypeEntityRepository;

    @Autowired
    CouponSecDetailEntityRepository couponSecDetailEntityRepository;

    @Override
    public ResponseEntity<?> createCoupon(PostCouponDTO postCouponDTO) throws JsonProcessingException {

        if(couponSecDetailEntityRepository
                .findByCouponNameAndClientUid(postCouponDTO.getCouponName(), postCouponDTO.getClientUid()) != null){

            throw new CustomException(409, "Coupon has already been created");
        }

        CouponTypeEntity couponTypeEntity = couponTypeEntityRepository.findByTypeId(postCouponDTO.getTypeId());

        if(couponTypeEntity == null){

            throw new CustomException(404, "Coupon Type ID not found");
        }


        if(!couponTypeEntity.getVar1Type().equals("null") && postCouponDTO.getVar1() == null){


            throw new CustomException(400, "Missing Coupon Detail var1");
        }


        if(!couponTypeEntity.getVar2Type().equals("null") && postCouponDTO.getVar2() == null){


            throw new CustomException(400, "Missing Coupon Detail var2  ");
        }


        if(!couponTypeEntity.getVar3Type().equals("null") && postCouponDTO.getVar3() == null){


            throw new CustomException(400, "Missing Coupon Detail var3");
        }

        CouponSecDetailEntity couponSecDetailEntity;

        try {
            couponSecDetailEntity = ConversionUtil.convertS2S(CouponSecDetailEntity.class, postCouponDTO);

        } catch (Exception e) {

            throw new CustomException(500, "Error in CouponServiceImpl createCoupon : ConversionUtil " + e.getMessage());
        }

        couponSecDetailEntityRepository.saveAndFlush(couponSecDetailEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create Coupon successful")
                .create(201);
    }
}