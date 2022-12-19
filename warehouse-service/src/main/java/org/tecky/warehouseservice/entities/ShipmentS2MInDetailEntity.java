package org.tecky.warehouseservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_shipment")
public class ShipmentS2MInDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shippment_id")
    private Integer shippmentId;

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

    @OneToMany(mappedBy="inDetailM2SShipmentEntity")
    private List<InDetailM2SShipmentEntity> inDetailM2SShipmentEntityList;


}