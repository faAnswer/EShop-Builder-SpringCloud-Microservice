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
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "shippment_companyID")
    private int shippmentCompanyid;

    @Column(name = "client_uid")
    private int clientUid;

    @Column(name = "warehouser_id")
    private int warehouserId;

    @Column(name = "shippment_num")
    private int shippmentNum;

    @Column(name = "progress_status")
    private String progressStatus;

    @Column(name = "direction_type")
    private String directionType;

}