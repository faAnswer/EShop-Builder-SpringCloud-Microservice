package org.tecky.inventoryservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.CategoryDTO;
import org.tecky.common.dto.InventoryDTO;
import org.tecky.common.dto.InventorySumDTO;
import org.tecky.common.dto.PostInventoryDTO;
import org.tecky.inventoryservice.entities.InventorySecDetailEntity;
import org.tecky.inventoryservice.mapper.InventorySecDetailEntityRepository;
import org.tecky.inventoryservice.service.intf.InventoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventorySecDetailEntityRepository inventorySecDetailEntityRepository;

    @Override
    public ResponseEntity<?> createInventory(PostInventoryDTO postInventoryDTO) throws JsonProcessingException {

        InventorySecDetailEntity inventorySecDetailEntity;

        if(inventorySecDetailEntityRepository
                .findByProductIdAndBatchNo(postInventoryDTO.getProductId(), postInventoryDTO.getBatchNo()) != null){

            throw new CustomException(409, "Batch No. has already existed");
        }

        try {
            inventorySecDetailEntity = ConversionUtil.convertS2S(InventorySecDetailEntity.class, postInventoryDTO);

        } catch (Exception e) {

            throw new CustomException(500, "Error InventoryServiceImpl createInventory: ConversionUtil");
        }

        inventorySecDetailEntityRepository.saveAndFlush(inventorySecDetailEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create Inventory successful")
                .create(201);
    }

    @Override
    //InventorySumDTO
    public ResponseEntity<?> getSummary(Integer productId) throws JsonProcessingException {

        List<InventorySecDetailEntity> inventorySecDetailEntityList = inventorySecDetailEntityRepository.findByProductId(productId);
        List<InventoryDTO> inventoryDTO = new ArrayList<InventoryDTO>();

        if(inventorySecDetailEntityList == null){

            throw new CustomException(404, "Product not found");
        }

        InventorySumDTO inventorySumDTO = new InventorySumDTO();

        inventorySumDTO.setProductId(productId);

        for(InventorySecDetailEntity inventorySecDetailEntity: inventorySecDetailEntityList){

            inventorySumDTO.setAvailableQty(inventorySumDTO.getAvailableQty() + inventorySecDetailEntity.getAvailableQty());
            inventorySumDTO.setAccountingQty(inventorySumDTO.getAccountingQty() + inventorySecDetailEntity.getAccountingQty());
            inventorySumDTO.setOnhandQty(inventorySumDTO.getOnhandQty() + inventorySecDetailEntity.getOnhandQty());
        }


        try {

            inventoryDTO = ConversionUtil.convertM2M(InventoryDTO.class, inventorySecDetailEntityList);

        } catch (Exception e) {

            throw new CustomException(500, "Error in InventoryServiceImpl getSummary: ConversionUtil");
        }

        inventorySumDTO.setInventories(inventoryDTO);

        return ResponseObject
                .builder()
                .setObjectPayLoad(inventorySumDTO)
                .create(200);
    }

}
