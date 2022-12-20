package org.tecky.warehouseservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_shipment")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shippment_id")
    private int shippmentId;

    @Column(name = "shippment_company")
    private String shippmentCompany;

    @Column(name = "warehouser_id")
    private int warehouserId;

    @Column(name = "shippment_num")
    private String shippmentNum;

    @Column(name = "progress_status")
    private String progressStatus;

    @Column(name = "direction_type")
    private String directionType;

}