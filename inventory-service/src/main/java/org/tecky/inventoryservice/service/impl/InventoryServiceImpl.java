package org.tecky.inventoryservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostInventoryDTO;
import org.tecky.inventoryservice.entities.InventoryEntity;
import org.tecky.inventoryservice.mapper.InventoryEntityRepository;
import org.tecky.inventoryservice.service.intf.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryEntityRepository inventoryEntityRepository;

    @Override
    public ResponseEntity<?> createInventory(PostInventoryDTO postInventoryDTO) throws JsonProcessingException {

        InventoryEntity inventoryEntity;

        if(inventoryEntityRepository
                .findByProductIdAndBatchNo(postInventoryDTO.getProductId(), postInventoryDTO.getBatchNo()) != null){

            throw new CustomException(409, "Batch No. has already existed");
        }

        try {
            inventoryEntity = ConversionUtil.convertS2S(InventoryEntity.class, postInventoryDTO);

        } catch (Exception e) {

            throw new CustomException(500, "Error InventoryServiceImpl createInventory: ConversionUtil");
        }

        inventoryEntityRepository.saveAndFlush(inventoryEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create Inventory successful")
                .create(201);
    }
}
