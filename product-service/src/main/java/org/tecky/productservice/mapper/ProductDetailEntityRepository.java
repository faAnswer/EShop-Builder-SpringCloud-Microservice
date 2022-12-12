package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.ProductDetailEntity;

public interface ProductDetailEntityRepository extends JpaRepository<ProductDetailEntity, String> {
}