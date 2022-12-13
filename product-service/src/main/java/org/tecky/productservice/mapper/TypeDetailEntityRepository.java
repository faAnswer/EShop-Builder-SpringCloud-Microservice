package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tecky.productservice.entities.TypeDetailEntity;

import java.util.List;

public interface TypeDetailEntityRepository extends JpaRepository<TypeDetailEntity, String> {

    @Query(value = "SELECT u FROM TypeDetailEntity u")
    public List<TypeDetailEntity> findAll();

    @Query(nativeQuery = true, value = "SELECT DISTINCT ttd.type_ID, ttd.type_name FROM t_type_detail AS ttd INNER JOIN t_type AS tt ON tt.type_ID = ttd.type_ID INNER JOIN t_group_detail AS tgd ON tgd.type_id = tt.type_ID WHERE tt.category_ID = :categoryId AND tgd.client_id = :clientId AND tgd.isvalid = 1")
    public List<TypeDetailEntity> findAllByCategoryIdAndClientId(@Param("categoryId") Integer categoryId, @Param("clientId") String clientId);

}