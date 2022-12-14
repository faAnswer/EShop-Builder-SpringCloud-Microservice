package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthEntity;
import org.tecky.uuaservice.entities.compk.RoleAuthEntityPK;

public interface RoleAuthEntityRepository extends JpaRepository<RoleAuthEntity, String> {
}