package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.ProductDetailEntity;

public interface ProductDetailEntityRepository extends JpaRepository<ProductDetailEntity, String> {
}