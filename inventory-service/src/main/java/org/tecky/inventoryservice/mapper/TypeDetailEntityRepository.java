package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.TypeDetailEntity;

public interface TypeDetailEntityRepository extends JpaRepository<TypeDetailEntity, String> {
}