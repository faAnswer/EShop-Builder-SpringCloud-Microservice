package org.tecky.warehouseservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.warehouseservice.entities.OutDetailEntity;

public interface OutDetailEntityRepository extends JpaRepository<OutDetailEntity, String> {
}