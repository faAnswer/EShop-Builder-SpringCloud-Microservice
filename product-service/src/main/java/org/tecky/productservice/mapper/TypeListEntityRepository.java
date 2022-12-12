package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.productservice.entities.TypeListEntity;

import java.util.List;

public interface TypeListEntityRepository extends JpaRepository<TypeListEntity, String> {

    public List<TypeListEntity> findByClientId(String clientId);
}
