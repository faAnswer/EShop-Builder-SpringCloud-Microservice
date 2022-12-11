package org.tecky.clientsideservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.clientsideservice.entities.CategoryEntity;

import java.util.List;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, String> {

    public List<CategoryEntity> findByClientId(String clientId);
}
