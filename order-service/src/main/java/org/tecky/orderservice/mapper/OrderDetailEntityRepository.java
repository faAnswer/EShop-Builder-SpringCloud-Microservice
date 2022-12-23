package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tecky.orderservice.entities.OrderDetailEntity;
@Transactional(rollbackFor = Exception.class)
public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, String> {
}