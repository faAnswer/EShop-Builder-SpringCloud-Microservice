package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.couponservice.entities.CouponEntity;

public interface CouponEntityRepository extends JpaRepository<CouponEntity, String> {

    public CouponEntity findByCouponId(Integer couponId);
}