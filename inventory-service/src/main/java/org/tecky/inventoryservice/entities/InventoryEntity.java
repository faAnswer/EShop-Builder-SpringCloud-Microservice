package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_inventory")
@SecondaryTable(name = "t_inventory_detail")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "product_id", table = "t_inventory")
    private int productId;

    @Column(name = "accounting_qty", table = "t_inventory")
    private int accountingQty;

    @Column(name = "available_qty", table = "t_inventory")
    private int availableQty;

    @Column(name = "onhand_qty", table = "t_inventory")
    private int onhandQty;

    @Column(name = "expiry_date", table = "t_inventory_detail")
    private String expiryDate;

    @Column(name = "addition_msg", table = "t_inventory_detail")
    private String additionMsg;

    @Column(name = "supplier", table = "t_inventory_detail")
    private String supplier;

    @Column(name = "supplier_contact", table = "t_inventory_detail")
    private String supplierContact;

    @Column(name = "batch_no", table = "t_inventory_detail")
    private String batchNo;

}