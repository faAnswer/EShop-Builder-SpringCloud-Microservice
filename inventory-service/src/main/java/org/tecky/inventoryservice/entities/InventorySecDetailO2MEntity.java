package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_inventory")
@SecondaryTable(name = "t_inventory_detail")
@Slf4j
public class InventorySecDetailO2MEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "product_id", table = "t_inventory")
    private Integer productId;

    @Column(name = "accounting_qty", table = "t_inventory")
    private Integer accountingQty;

    @Column(name = "available_qty", table = "t_inventory")
    private Integer availableQty;

    @Column(name = "onhand_qty", table = "t_inventory")
    private Integer onhandQty;

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

    @OneToMany(mappedBy= "inventorySecDetailO2MEntity", cascade = CascadeType.ALL)
    private List<AvailableDetailM2OEntity> availableDetailM2OEntity;

    @OneToMany(mappedBy= "inventorySecDetailO2MEntity", cascade = CascadeType.ALL)
    private List<OnhandDetailM2OEntity> onhandDetailM2OEntity;

    @OneToMany(mappedBy= "inventorySecDetailO2MEntity", cascade = CascadeType.ALL)
    private List<AccountingDetailM2OEntity> accountingDetailM2OEntity;
}
