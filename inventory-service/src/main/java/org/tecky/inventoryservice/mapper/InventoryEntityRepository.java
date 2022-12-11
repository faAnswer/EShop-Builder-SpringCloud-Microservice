package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.InventoryEntity;

public interface InventoryEntityRepository extends JpaRepository<InventoryEntity, String> {
}