package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;
import org.tecky.uuaservice.entities.RoleEntity;

import java.util.List;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, String> {

    public RoleEntity findByRoleId(Integer roleId);

    public RoleEntity findByRoleNameAndClientUid(@Param("roleName") String roleName, @Param("clientUid") Integer clientUid);



}