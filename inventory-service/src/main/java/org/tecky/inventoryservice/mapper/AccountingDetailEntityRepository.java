package org.tecky.inventoryservice.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecky.inventoryservice.entities.AccountingDetailEntity;

public interface AccountingDetailEntityRepository extends JpaRepository<AccountingDetailEntity, String> {
}