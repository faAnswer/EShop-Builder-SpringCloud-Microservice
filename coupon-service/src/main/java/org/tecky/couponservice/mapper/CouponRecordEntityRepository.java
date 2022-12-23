package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.couponservice.entities.CouponRecordEntity;

public interface CouponRecordEntityRepository extends JpaRepository<CouponRecordEntity, String> {
}