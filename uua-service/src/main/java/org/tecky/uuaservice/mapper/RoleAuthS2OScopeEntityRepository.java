package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;

public interface RoleAuthS2OScopeEntityRepository extends JpaRepository<RoleAuthS2OScopeEntity, String> {

    public RoleAuthS2OScopeEntity findByRoleId(Integer roleId);

}