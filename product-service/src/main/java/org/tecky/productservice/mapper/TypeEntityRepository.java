package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.tecky.productservice.entities.TypeEntity;

import java.util.List;

public interface TypeEntityRepository extends JpaRepository<TypeEntity, String> {

    @Query(nativeQuery = true, value = "SELECT tt.category_ID, tt.type_ID FROM t_type AS tt INNER JOIN t_category_detail AS tcd ON tt.category_ID = tcd.category_ID INNER JOIN t_type_detail AS ttd ON ttd.type_ID = tt.type_ID")
    public List<TypeEntity> findAllValidType();

}