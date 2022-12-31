package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_onhand_detail")
public class OnhandDetailM2OEntity {

    @Id
    @Column(name = "ref_id")
    private Integer refId;

    @Column(name = "onhand_diff")
    private Integer onhandDiff;

    @Column(name = "shipment_id")
    private Integer shipmentId;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private InventorySecDetailO2MEntity inventorySecDetailO2MEntity;

}