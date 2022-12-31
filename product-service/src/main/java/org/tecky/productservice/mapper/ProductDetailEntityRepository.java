package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tecky.productservice.entities.ProductDetailEntity;

import java.util.List;

public interface ProductDetailEntityRepository extends JpaRepository<ProductDetailEntity, String> {

    public List<ProductDetailEntity> findByGroupIdAndIsvalidIs(Integer groupId, Integer isValidIs);

    public List<ProductDetailEntity> findByGroupId(Integer groupId);

}