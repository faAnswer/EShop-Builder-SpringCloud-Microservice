package org.tecky.clientsideservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.clientsideservice.entities.TypeDetailEntity;

public interface TypeDetailEntityRepository extends JpaRepository<TypeDetailEntity, String> {
}