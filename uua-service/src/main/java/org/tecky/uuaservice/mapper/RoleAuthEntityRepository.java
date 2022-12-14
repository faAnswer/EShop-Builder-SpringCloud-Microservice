package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthEntity;

public interface RoleAuthEntityRepository extends JpaRepository<RoleAuthEntity, String> {
}