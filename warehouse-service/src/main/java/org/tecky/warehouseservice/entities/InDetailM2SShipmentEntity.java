package org.tecky.warehouseservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_in_detail")
public class InDetailM2SShipmentEntity {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "ref_pic")
    private String refPic;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "record_ref")
    private String recordRef;

    @Column(name = "handler_uid")
    private Integer handlerUid;

    @Column(name = "addition_msg")
    private String additionMsg;

    @ManyToOne
    @JoinColumn(name = "shippment_id", referencedColumnName = "shippment_id")
    private ShipmentS2MInDetailEntity shipmentS2MInDetailEntity;

}