package org.tecky.orderservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tecky.orderservice.entities.DetailM2SOrderEntity;
@Transactional(rollbackFor = Exception.class)
public interface DetailM2SOrderEntityRepository extends JpaRepository<DetailM2SOrderEntity, String> {
}