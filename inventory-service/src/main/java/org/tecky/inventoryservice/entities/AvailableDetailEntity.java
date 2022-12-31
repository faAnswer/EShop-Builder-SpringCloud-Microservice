package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_available_detail")
public class AvailableDetailEntity {

    @Id
    @Column(name = "ref_id")
    private Integer refId;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "available_diff")
    private Integer availableDiff;

    @Column(name = "order_id")
    private Integer orderId;

}