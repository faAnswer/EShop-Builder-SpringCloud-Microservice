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
@Table(name = "t_accounting_detail")
public class AccountingDetailEntity {

    @Id
    @Column(name = "ref_id")
    private int refId;

    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "accounting_diff")
    private int accountingDiff;

    @Column(name = "order_id")
    private int orderId;

}