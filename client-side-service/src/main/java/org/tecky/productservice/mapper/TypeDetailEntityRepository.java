package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.TypeDetailEntity;

public interface TypeDetailEntityRepository extends JpaRepository<TypeDetailEntity, String> {
}