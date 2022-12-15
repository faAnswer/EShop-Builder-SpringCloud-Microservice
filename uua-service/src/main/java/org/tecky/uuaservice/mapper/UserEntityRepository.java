package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

    public UserEntity findByEmailAndRoleId(String email, Integer roleId);
    public UserEntity findByUsernameAndRoleId(String username, Integer roleId);
    public UserEntity findByEmailAndClientUid(String email, Integer clientUid);

}