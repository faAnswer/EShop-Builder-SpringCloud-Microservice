package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.GroupDetailEntity;

public interface GroupDetailEntityRepository extends JpaRepository<GroupDetailEntity, String> {

    public GroupDetailEntity findByGroupId(Integer groupId);

}