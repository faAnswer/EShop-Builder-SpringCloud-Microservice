package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.ProductDetailEntity;

import java.util.List;

public interface ProductDetailEntityRepository extends JpaRepository<ProductDetailEntity, String> {

    public List<ProductDetailEntity> findDistinctColaValueByGroupId(Integer groupId);
}