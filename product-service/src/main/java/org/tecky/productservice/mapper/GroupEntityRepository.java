package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.GroupEntity;

public interface GroupEntityRepository extends JpaRepository<GroupEntity, String> {
}