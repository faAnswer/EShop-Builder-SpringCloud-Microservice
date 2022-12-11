package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.OnhandDetailEntity;

public interface OnhandDetailEntityRepository extends JpaRepository<OnhandDetailEntity, String> {
}