package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {
}