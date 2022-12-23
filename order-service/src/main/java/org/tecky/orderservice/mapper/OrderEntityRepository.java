package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.orderservice.entities.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, String> {
}