package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.CategoryDetailEntity;

public interface CategoryDetailEntityRepository extends JpaRepository<CategoryDetailEntity, String> {
}