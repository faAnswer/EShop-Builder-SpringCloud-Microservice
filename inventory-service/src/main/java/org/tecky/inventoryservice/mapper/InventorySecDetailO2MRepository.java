package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.InventorySecDetailO2M;

public interface InventorySecDetailO2MRepository extends JpaRepository<InventorySecDetailO2M, String> {
}