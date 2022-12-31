package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.InventoryDetailEntity;

public interface InventoryDetailEntityRepository extends JpaRepository<InventoryDetailEntity, String> {
}