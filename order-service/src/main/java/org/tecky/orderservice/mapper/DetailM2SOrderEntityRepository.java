package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.orderservice.entities.DetailM2SOrderEntity;

public interface DetailM2SOrderEntityRepository extends JpaRepository<DetailM2SOrderEntity, String> {
}