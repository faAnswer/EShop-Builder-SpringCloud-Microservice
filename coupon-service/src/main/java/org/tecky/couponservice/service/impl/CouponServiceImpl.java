package org.tecky.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.util.MySQLDateUtil;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.RestTempBuilder;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PatchCouponDTO;
import org.tecky.common.dto.PostCouponDTO;
import org.tecky.couponservice.entities.CouponRecordEntity;
import org.tecky.couponservice.entities.CouponSecDetailEntity;
import org.tecky.couponservice.entities.CouponTypeEntity;
import org.tecky.couponservice.mapper.CouponEntityRepository;
import org.tecky.couponservice.mapper.CouponRecordEntityRepository;
import org.tecky.couponservice.mapper.CouponSecDetailEntityRepository;
import org.tecky.couponservice.mapper.CouponTypeEntityRepository;
import org.tecky.couponservice.service.intf.ICouponService;

import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    CouponEntityRepository couponEntityRepository;

    @Autowired
    CouponTypeEntityRepository couponTypeEntityRepository;

    @Autowired
    CouponSecDetailEntityRepository couponSecDetailEntityRepository;

    @Autowired
    CouponRecordEntityRepository couponRecordEntityRepository;


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

    @Override
    public ResponseEntity<?> getCouponDiscount(PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        CouponSecDetailEntity couponSecDetailEntity;

        couponSecDetailEntity = couponSecDetailEntityRepository.findByCouponId(patchCouponDTO.getCouponId());

        if(couponSecDetailEntity == null){

            throw new CustomException(404, "Coupon ID not found");
        }

        if(couponSecDetailEntity.getUid() != 0 && !Objects.equals(couponSecDetailEntity.getUid(), patchCouponDTO.getUid())){

            throw new CustomException(403, "Coupon cannot be applied");

        }

        if(!Objects.equals(couponSecDetailEntity.getClientUid(), patchCouponDTO.getClientUid())){

            throw new CustomException(403, "Invalid Coupon ID");
        }

        if(couponSecDetailEntity.getAvailableQty() <= 0){

            throw new CustomException(400, "Coupon is more than the number of use");
        }

        Date date;

        try {
            date = MySQLDateUtil.dateToDate(couponSecDetailEntity.getExpiryDate());

        } catch (Exception e) {

            throw new CustomException(500, "Error in CouponServiceImpl patchCoupon : MySQLDateUtil " + e.getMessage());
        }

        if(date.before(Date.from(Instant.now()))){

            throw new CustomException(400, "Coupon is expired");
        }

        ResponseEntity<?> res = null;

        Integer couponType = couponSecDetailEntity.getTypeId();


        if(couponType == 1){

            res = type1Coupon(couponSecDetailEntity, patchCouponDTO);
        } else if(couponType == 2) {


            res = type2Coupon(couponSecDetailEntity, patchCouponDTO);
        } else if(couponType == 3){

            res = type3Coupon(couponSecDetailEntity, patchCouponDTO);

        } else if(couponType == 4) {

            res = type4Coupon(couponSecDetailEntity, patchCouponDTO);

        } else {

            throw new CustomException(500, "Error in CouponServiceImpl patchCoupon : Type ID Invalid");
        }

        return res;
    }

    @Override
    public ResponseEntity<?> patchCoupon(PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        ResponseEntity<?> res = getCouponDiscount(patchCouponDTO);

        Map<String, String> map = (Map<String, String>) ResponseObject.convert2Object(res);

        Integer discount = Integer.valueOf(map.get("discount"));

        CouponRecordEntity couponRecordEntity;

        try {
            couponRecordEntity = ConversionUtil.convertS2S(CouponRecordEntity.class, patchCouponDTO);


        } catch (Exception e) {

            throw new CustomException(500, "Error in CouponServiceImpl patchCoupon : ConversionUtil " + e.getMessage());
        }

        couponRecordEntity.setDiscount(discount);
        couponRecordEntityRepository.saveAndFlush(couponRecordEntity);
        couponEntityRepository.decrementQty(patchCouponDTO.getCouponId(), 1);


        return ResponseObject
                .builder()
                .setPayLoad("message", "Apply Coupon successful")
                .create(200);
    }

    private ResponseEntity<?> type1Coupon(CouponSecDetailEntity couponSecDetailEntity, PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        if(couponSecDetailEntity.getVar1() > patchCouponDTO.getSubtotal()){

            throw new CustomException(400, "單一訂單必須超過 $" + couponSecDetailEntity.getVar1());
        }


        return ResponseObject
                .builder()
                .setPayLoad("discount", couponSecDetailEntity.getVar2().toString())
                .create(200);
    }

    private ResponseEntity<?> type2Coupon(CouponSecDetailEntity couponSecDetailEntity, PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        if(couponSecDetailEntity.getVar1() > patchCouponDTO.getSubtotal()){

            throw new CustomException(400, "單一訂單必須超過 $" + couponSecDetailEntity.getVar1());
        }

        Integer discount = (100 - couponSecDetailEntity.getVar2()) * patchCouponDTO.getSubtotal() / 100;

        Integer maxDiscount = couponSecDetailEntity.getVar3();

        if(discount > maxDiscount){

            discount = maxDiscount;
        }

        return ResponseObject
                .builder()
                .setPayLoad("discount", discount.toString())
                .create(200);
    }

    private ResponseEntity<?> type3Coupon(CouponSecDetailEntity couponSecDetailEntity, PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        if(couponSecDetailEntity.getVar1() > patchCouponDTO.getSubtotal()){

            throw new CustomException(400, "單一訂單必須超過 $" + couponSecDetailEntity.getVar1());
        }


        return ResponseObject
                .builder()
                .setPayLoad("discount", couponSecDetailEntity.getVar2().toString())
                .create(200);
    }

    private ResponseEntity<?> type4Coupon(CouponSecDetailEntity couponSecDetailEntity, PatchCouponDTO patchCouponDTO) throws JsonProcessingException {

        return ResponseObject
                .builder()
                .setPayLoad("discount", couponSecDetailEntity.getVar1().toString())
                .create(200);
    }
}