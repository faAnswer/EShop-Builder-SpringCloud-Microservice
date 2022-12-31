package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tecky.productservice.entities.ProductDetailEntity;

import java.util.List;

public interface ProductDetailEntityRepository extends JpaRepository<ProductDetailEntity, String> {

    public List<ProductDetailEntity> findByGroupIdAndIsvalidIs(Integer groupId, Integer isValidIs);

    public List<ProductDetailEntity> findByGroupId(Integer groupId);

    @Query(nativeQuery = true,
    value = "SELECT t1.* FROM t_product_detail AS t1 INNER JOIN (SELECT product_id, ROW_NUMBER() OVER(PARTITION BY colA_value, group_id) as rownum FROM t_product_detail) AS t2 ON t1.product_id = t2.product_id WHERE t2.rownum = 1 AND t1.group_id = ?1")
    public List<ProductDetailEntity> findDistinctColaValueByGroupId(Integer groupId);

}