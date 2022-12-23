package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.orderservice.entities.OrderDetailEntity;

public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, String> {
}