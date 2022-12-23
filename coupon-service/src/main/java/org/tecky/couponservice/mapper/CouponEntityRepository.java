package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.tecky.couponservice.entities.CouponEntity;

public interface CouponEntityRepository extends JpaRepository<CouponEntity, String> {

    public CouponEntity findByCouponId(Integer couponId);

    @Modifying
    @Transactional(rollbackFor = {RuntimeException.class})
    @Query(value = "UPDATE t_coupon SET available_qty = available_qty - ?2 WHERE coupon_id = ?1", nativeQuery = true)
    public void decrementQty(Integer couponId, Integer num);
}