package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.TypeEntity;

public interface TypeEntityRepository extends JpaRepository<TypeEntity, String> {
}