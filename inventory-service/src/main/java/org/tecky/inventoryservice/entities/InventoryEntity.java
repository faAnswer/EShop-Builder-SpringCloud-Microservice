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
@Table(name = "t_inventory")
public class InventoryEntity {

    @Id
    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "accounting_qty")
    private int accountingQty;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "available_qty")
    private int availableQty;

    @Column(name = "onhand_qty")
    private int onhandQty;

}