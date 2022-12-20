package org.tecky.warehouseservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostWarehouseDTO;
import org.tecky.warehouseservice.entities.WarehouseEntity;
import org.tecky.warehouseservice.mapper.WarehouseEntityRepository;
import org.tecky.warehouseservice.service.intf.IWarehouseService;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    WarehouseEntityRepository warehouseEntityRepository;

    @Override
    public ResponseEntity<?> createWarehouse(PostWarehouseDTO postWarehouseDTO) throws JsonProcessingException {

        WarehouseEntity warehouseEntity;

        if(warehouseEntityRepository
                .findByWarehouseNameAndClientUid(postWarehouseDTO.getWarehouseName(), postWarehouseDTO.getClientUid()) != null){

            throw new CustomException(409, "WarehouseName has existed");
        }

        try {

            warehouseEntity = ConversionUtil.convertS2S(WarehouseEntity.class, postWarehouseDTO);

        } catch (Exception e) {

            throw new CustomException(500, "Error in WarehouseServiceImpl createWarehouse: ConversionUtil");
        }

        warehouseEntityRepository.saveAndFlush(warehouseEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create Warehouse successful")
                .create(201);
    }
}
