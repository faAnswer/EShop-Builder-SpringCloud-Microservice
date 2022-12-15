package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.RoleAuthEntity;
import org.tecky.uuaservice.entities.RoleEntity;
import org.tecky.uuaservice.entities.compk.RoleAuthEntityPK;

import java.util.List;

public interface RoleAuthEntityRepository extends JpaRepository<RoleAuthEntity, String> {

    public List<RoleAuthEntity> findByRoleId(Integer roleId);
    public List<RoleAuthEntity> findAllByRoleId(Integer roleId);

}