package org.tecky.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.api.inventoryservice.InventoryAPI;
import org.tecky.inventoryservice.entities.InventorySecDetailO2MEntity;
import org.tecky.inventoryservice.mapper.InventorySecDetailO2MRepository;


@RestController
@RequestMapping("/api")
public class TestContoller {

    @Autowired
    InventorySecDetailO2MRepository inventorySecDetailO2MRepository;

    @GetMapping("/v1/test")
    public String test(){

        InventorySecDetailO2MEntity inventorySecDetailO2MEntity = inventorySecDetailO2MRepository.findByInventoryId(2);

        return "OK";
    }

}