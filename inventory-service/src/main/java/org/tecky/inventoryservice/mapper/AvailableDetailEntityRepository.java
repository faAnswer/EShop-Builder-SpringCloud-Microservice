package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.AvailableDetailEntity;

public interface AvailableDetailEntityRepository extends JpaRepository<AvailableDetailEntity, String> {
}