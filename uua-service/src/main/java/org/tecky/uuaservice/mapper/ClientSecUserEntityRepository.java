package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.ClientSecUserEntity;

public interface ClientSecUserEntityRepository extends JpaRepository<ClientSecUserEntity, String> {
}