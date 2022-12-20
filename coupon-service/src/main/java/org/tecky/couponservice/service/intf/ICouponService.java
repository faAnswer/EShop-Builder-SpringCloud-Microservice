package org.tecky.couponservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PatchCouponDTO;
import org.tecky.common.dto.PostCouponDTO;

public interface ICouponService {

    public ResponseEntity<?> createCoupon(PostCouponDTO postCouponDTO) throws JsonProcessingException;

    public ResponseEntity<?> getCouponDiscount(PatchCouponDTO patchCouponDTO) throws JsonProcessingException;

}
