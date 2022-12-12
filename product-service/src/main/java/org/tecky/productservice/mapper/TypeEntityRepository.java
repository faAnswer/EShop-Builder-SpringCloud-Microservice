package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.TypeEntity;

public interface TypeEntityRepository extends JpaRepository<TypeEntity, String> {
}