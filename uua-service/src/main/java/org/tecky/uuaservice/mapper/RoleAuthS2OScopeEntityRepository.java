package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;

import java.util.List;

public interface RoleAuthS2OScopeEntityRepository extends JpaRepository<RoleAuthS2OScopeEntity, String> {

    public List<RoleAuthS2OScopeEntity> findByRoleId(Integer roleId);

}