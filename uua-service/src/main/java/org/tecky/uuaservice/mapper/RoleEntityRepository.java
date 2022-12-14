package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, String> {
}