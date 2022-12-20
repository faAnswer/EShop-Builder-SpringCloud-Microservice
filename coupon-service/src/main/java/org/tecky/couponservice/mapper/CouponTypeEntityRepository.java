package org.tecky.couponservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.couponservice.entities.CouponTypeEntity;

public interface CouponTypeEntityRepository extends JpaRepository<CouponTypeEntity, String> {

    public CouponTypeEntity findByTypeId(Integer typeId);


}