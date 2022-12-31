package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "t_accounting_detail")
public class AccountingDetailM2OEntity {

    @Id
    @Column(name = "ref_id")
    private Integer refId;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "accounting_diff")
    private Integer accountingDiff;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private InventorySecDetailO2MEntity inventorySecDetailO2MEntity;
}