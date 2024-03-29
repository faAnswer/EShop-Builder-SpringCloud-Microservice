package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_accounting_detail")
public class AccountingDetailEntity {

    @Id
    @Column(name = "ref_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer refId;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "accounting_diff")
    private Integer accountingDiff;

    @Column(name = "order_id")
    private Integer orderId;

}