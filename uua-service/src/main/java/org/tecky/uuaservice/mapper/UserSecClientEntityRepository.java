package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.UserSecClientEntity;

public interface UserSecClientEntityRepository extends JpaRepository<UserSecClientEntity, String> {
}