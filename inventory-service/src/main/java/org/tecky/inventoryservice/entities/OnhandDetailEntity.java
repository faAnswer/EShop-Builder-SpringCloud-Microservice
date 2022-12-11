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
@Table(name = "t_onhand_detail")
public class OnhandDetailEntity {

    @Id
    @Column(name = "ref_id")
    private int refId;

    @Column(name = "onhand_diff")
    private int onhandDiff;

    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "shipment_id")
    private int shipmentId;

}