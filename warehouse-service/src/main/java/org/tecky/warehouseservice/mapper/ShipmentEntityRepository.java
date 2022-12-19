package org.tecky.warehouseservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.warehouseservice.entities.ShipmentEntity;

public interface ShipmentEntityRepository extends JpaRepository<ShipmentEntity, String> {
}