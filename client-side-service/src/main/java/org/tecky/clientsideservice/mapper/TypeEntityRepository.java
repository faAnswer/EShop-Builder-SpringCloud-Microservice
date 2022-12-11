package org.tecky.clientsideservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.clientsideservice.entities.TypeEntity;

public interface TypeEntityRepository extends JpaRepository<TypeEntity, String> {
}