package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.InventorySecDetailO2MEntity;

public interface InventorySecDetailO2MRepository extends JpaRepository<InventorySecDetailO2MEntity, String> {

    public InventorySecDetailO2MEntity findByInventoryId(Integer inventoryId);
}