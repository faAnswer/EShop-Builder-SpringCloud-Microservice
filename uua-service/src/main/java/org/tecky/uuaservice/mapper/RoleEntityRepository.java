package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;
import org.tecky.uuaservice.entities.RoleEntity;

import java.util.List;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, String> {

    public List<RoleEntity> findByRoleId(Integer roleId);

}