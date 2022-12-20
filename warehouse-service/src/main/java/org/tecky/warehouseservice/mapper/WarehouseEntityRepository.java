package org.tecky.warehouseservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.warehouseservice.entities.WarehouseEntity;

public interface WarehouseEntityRepository extends JpaRepository<WarehouseEntity, String> {

    public WarehouseEntity findByWarehouseNameAndClientUid(@Param("warehouseName") String warehouseName, @Param("clientUid") Integer clientUid);

    public WarehouseEntity findByWarehouseId(Integer warehouseId);


}