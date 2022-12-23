package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tecky.orderservice.entities.OrderS2MDetailEntity;
@Transactional(rollbackFor = Exception.class)
public interface OrderS2MDetailEntityRepository extends JpaRepository<OrderS2MDetailEntity, String> {
}