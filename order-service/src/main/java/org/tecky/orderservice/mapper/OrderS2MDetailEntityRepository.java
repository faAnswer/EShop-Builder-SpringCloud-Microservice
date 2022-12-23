package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.orderservice.entities.OrderS2MDetailEntity;

public interface OrderS2MDetailEntityRepository extends JpaRepository<OrderS2MDetailEntity, String> {
}