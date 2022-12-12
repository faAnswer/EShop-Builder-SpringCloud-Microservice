package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tecky.productservice.entities.TypeDetailEntity;

import java.util.List;

public interface TypeDetailEntityRepository extends JpaRepository<TypeDetailEntity, String> {

    @Query(value = "SELECT u FROM TypeDetailEntity u")
    public List<TypeDetailEntity> findAll();

}