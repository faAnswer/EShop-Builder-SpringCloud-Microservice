package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_available_detail")
public class AvailableDetailM2OEntity {

    @Id
    @Column(name = "ref_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer refId;

    @Column(name = "available_diff")
    private Integer availableDiff;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private InventorySecDetailO2MEntity inventorySecDetailO2MEntity;
}