package org.tecky.warehouseservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostWarehouseInShipmentDTO;
import org.tecky.warehouseservice.entities.InDetailM2SShipmentEntity;
import org.tecky.warehouseservice.entities.ShipmentS2MInDetailEntity;
import org.tecky.warehouseservice.mapper.ShipmentS2MInDetailEntityRepository;
import org.tecky.warehouseservice.mapper.WarehouseEntityRepository;
import org.tecky.warehouseservice.service.intf.IShipmentService;

import java.util.List;

@Service
public class ShipmentServiceImpl implements IShipmentService {

    @Autowired
    WarehouseEntityRepository warehouseEntityRepository;

    @Autowired
    ShipmentS2MInDetailEntityRepository shipmentS2MInDetailEntityRepository;

    @Override
    public ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO postWarehouseInShipmentDTO) throws JsonProcessingException {

        if(warehouseEntityRepository.findByWarehouseId(postWarehouseInShipmentDTO.getWarehouserId()) == null){

            throw new CustomException(400, "Invalid warehouse id");
        }

        ShipmentS2MInDetailEntity shipmentS2MInDetailEntity;
        List<InDetailM2SShipmentEntity> inDetailM2SShipmentEntityList;

        try {

            shipmentS2MInDetailEntity = ConversionUtil.convertS2S(ShipmentS2MInDetailEntity.class, postWarehouseInShipmentDTO);
            inDetailM2SShipmentEntityList = ConversionUtil.convertM2M(InDetailM2SShipmentEntity.class, postWarehouseInShipmentDTO.getPostWarehouseInDTOList());
        } catch (Exception e) {

            throw new CustomException(500, "Error in ShipmentServiceImpl createInShipment: ConversionUtil");
        }

        for(InDetailM2SShipmentEntity inDetailM2SShipmentEntity: inDetailM2SShipmentEntityList){


            inDetailM2SShipmentEntity.setShipmentS2MInDetailEntity(shipmentS2MInDetailEntity);
        }

        shipmentS2MInDetailEntity.setInDetailM2SShipmentEntityList(inDetailM2SShipmentEntityList);

        shipmentS2MInDetailEntityRepository.saveAndFlush(shipmentS2MInDetailEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create In-Shipment successful")
                .create(201);
    }
}
