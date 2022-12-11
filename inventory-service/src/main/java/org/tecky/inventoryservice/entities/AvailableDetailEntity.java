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
@Table(name = "t_available_detail")
public class AvailableDetailEntity {

    @Id
    @Column(name = "ref_id")
    private int refId;

    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "available_diff")
    private int availableDiff;

    @Column(name = "order_id")
    private int orderId;

}