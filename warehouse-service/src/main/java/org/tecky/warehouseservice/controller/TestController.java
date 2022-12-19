package org.tecky.warehouseservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.warehouseservice.entities.InDetailM2SShipmentEntity;
import org.tecky.warehouseservice.entities.ShipmentS2MInDetailEntity;
import org.tecky.warehouseservice.mapper.ShipmentS2MInDetailEntityRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    ShipmentS2MInDetailEntityRepository shipmentS2MInDetailEntityRepository;

    @GetMapping("/v1/test")
    public String getTest(){

        ShipmentS2MInDetailEntity shipmentS2MInDetailEntity = new ShipmentS2MInDetailEntity();

        List<InDetailM2SShipmentEntity> inDetailM2SShipmentEntityList = new ArrayList<>();

        InDetailM2SShipmentEntity inDetailM2SShipmentEntityA = new InDetailM2SShipmentEntity();

        inDetailM2SShipmentEntityA.setInventoryId(100);
        inDetailM2SShipmentEntityA.setQty(3);

        inDetailM2SShipmentEntityList.add(inDetailM2SShipmentEntityA);

        InDetailM2SShipmentEntity inDetailM2SShipmentEntityB = new InDetailM2SShipmentEntity();
        inDetailM2SShipmentEntityB.setInventoryId(200);
        inDetailM2SShipmentEntityB.setQty(5);

        inDetailM2SShipmentEntityList.add(inDetailM2SShipmentEntityB);

        shipmentS2MInDetailEntity.setShippmentNum("S12345");
        shipmentS2MInDetailEntity.setShippmentCompany("SF");
        shipmentS2MInDetailEntity.setInDetailM2SShipmentEntityList(inDetailM2SShipmentEntityList);

        shipmentS2MInDetailEntityRepository.saveAndFlush(shipmentS2MInDetailEntity);

        return "OK";
    }
}
