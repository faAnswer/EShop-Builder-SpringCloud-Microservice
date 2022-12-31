package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_available_detail")
public class AvailableDetailO2MEntity {

    @Id
    @Column(name = "ref_id")
    private int refId;

    @Column(name = "available_diff")
    private int availableDiff;

    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private InventorySecDetailO2M inventorySecDetailO2M;
}