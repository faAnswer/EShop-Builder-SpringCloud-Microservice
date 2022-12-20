package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.couponservice.entities.CouponDetailEntity;

public interface CouponDetailEntityRepository extends JpaRepository<CouponDetailEntity, String> {
}