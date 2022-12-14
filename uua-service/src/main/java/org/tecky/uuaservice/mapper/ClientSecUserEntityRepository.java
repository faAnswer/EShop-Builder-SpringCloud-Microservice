package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.uuaservice.entities.ClientSecUserEntity;

public interface ClientSecUserEntityRepository extends JpaRepository<ClientSecUserEntity, String> {

    public ClientSecUserEntity findByClientIdAndEmail(@Param("clientId") String clientId, @Param("email") String email);
}