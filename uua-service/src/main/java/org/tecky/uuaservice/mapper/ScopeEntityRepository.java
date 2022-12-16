package org.tecky.uuaservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.uuaservice.entities.ScopeEntity;

public interface ScopeEntityRepository extends JpaRepository<ScopeEntity, String> {

    public ScopeEntity findByScopeId(Integer scopeId);
}