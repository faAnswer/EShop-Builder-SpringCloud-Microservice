package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.couponservice.entities.CouponSecDetailEntity;

public interface CouponSecDetailEntityRepository extends JpaRepository<CouponSecDetailEntity, String> {

    public CouponSecDetailEntity findByCouponNameAndClientUid(@Param("couponName") String couponName, @Param("clientUid") Integer clientUid);

}