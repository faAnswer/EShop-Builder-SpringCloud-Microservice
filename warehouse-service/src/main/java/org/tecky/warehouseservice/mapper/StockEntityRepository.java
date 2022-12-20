package org.tecky.warehouseservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.warehouseservice.entities.StockEntity;

public interface StockEntityRepository extends JpaRepository<StockEntity, String> {
}