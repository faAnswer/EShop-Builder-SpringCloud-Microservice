package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.ClientEntity;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, String> {

    public ClientEntity findByClientId(String clientId);
    public ClientEntity findByClientName(String clientName);

}