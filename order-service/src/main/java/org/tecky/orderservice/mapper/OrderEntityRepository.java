package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tecky.orderservice.entities.OrderEntity;
@Transactional(rollbackFor = Exception.class)
public interface OrderEntityRepository extends JpaRepository<OrderEntity, String> {
}