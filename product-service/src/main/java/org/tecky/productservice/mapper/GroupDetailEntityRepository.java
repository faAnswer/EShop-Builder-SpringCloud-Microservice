package org.tecky.productservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.tecky.productservice.entities.GroupDetailEntity;

import java.util.List;

public interface GroupDetailEntityRepository extends JpaRepository<GroupDetailEntity, String> {

    public GroupDetailEntity findByGroupId(Integer groupId);
    public List<GroupDetailEntity> findByTypeIdAndClientId(@Param("typeId") Integer typeId, @Param("clientId") String clientId);

}