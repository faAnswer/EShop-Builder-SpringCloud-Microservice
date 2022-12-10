package org.tecky.uaaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.uaaservice.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

    public UserEntity findByUsernameAndClientId(@Param("username") String username, @Param("client_id") String client_id);

    public UserEntity findByEmailAndClientId(@Param("email")String email, @Param("client_id") String client_id);
}
