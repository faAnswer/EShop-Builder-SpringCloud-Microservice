package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tecky.productservice.entities.CategoryDetailEntity;

import java.util.List;

public interface CategoryDetailEntityRepository extends JpaRepository<CategoryDetailEntity, String> {


    @Query(nativeQuery = true, value = "SELECT tcd.category_ID, tcd.category_name FROM t_group_detail AS tgd INNER JOIN t_type AS tt ON tt.type_ID = tgd.type_ID INNER JOIN t_category_detail AS tcd ON tcd.category_ID = tt.category_ID WHERE tgd.client_ID = ?1")
    public List<CategoryDetailEntity> findAllCategoryByClientId(String clientId);


}