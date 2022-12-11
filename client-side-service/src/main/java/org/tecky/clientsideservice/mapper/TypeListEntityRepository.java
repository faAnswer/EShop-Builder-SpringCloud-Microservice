package org.tecky.clientsideservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.clientsideservice.entities.TypeListEntity;

import java.util.List;

public interface TypeListEntityRepository extends JpaRepository<TypeListEntity, String> {

    public List<TypeListEntity> findByClientId(String clientId);
}
