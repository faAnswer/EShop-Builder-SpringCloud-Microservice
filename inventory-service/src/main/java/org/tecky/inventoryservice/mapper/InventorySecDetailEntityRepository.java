package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.inventoryservice.entities.InventorySecDetailEntity;

import java.util.List;

public interface InventorySecDetailEntityRepository extends JpaRepository<InventorySecDetailEntity, String> {

    public InventorySecDetailEntity findByProductIdAndBatchNo(@Param("productId") Integer productId, @Param("batchNo") String batchNo);

    public List<InventorySecDetailEntity> findByProductId(@Param("productId") Integer productId);

}