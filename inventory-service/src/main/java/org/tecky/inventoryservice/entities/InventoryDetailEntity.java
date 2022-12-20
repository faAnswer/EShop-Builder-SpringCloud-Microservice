package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_inventory_detail")
public class InventoryDetailEntity {

    @Id
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "addition_msg")
    private String additionMsg;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "supplier_contact")
    private String supplierContact;

    @Column(name = "batch_no")
    private String batchNo;
}