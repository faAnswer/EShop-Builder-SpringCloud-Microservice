package org.tecky.warehouseservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.warehouseservice.entities.InDetailEntity;

public interface InDetailEntityRepository extends JpaRepository<InDetailEntity, String> {
}