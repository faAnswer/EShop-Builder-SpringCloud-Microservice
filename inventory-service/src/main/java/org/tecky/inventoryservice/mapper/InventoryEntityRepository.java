package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.inventoryservice.entities.InventoryEntity;

public interface InventoryEntityRepository extends JpaRepository<InventoryEntity, String> {

    public InventoryEntity findByProductIdAndBatchNo(@Param("productId") Integer productId, @Param("batchNo") String batchNo);
}