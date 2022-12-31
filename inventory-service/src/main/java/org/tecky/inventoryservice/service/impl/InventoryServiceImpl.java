package org.tecky.inventoryservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.*;
import org.tecky.inventoryservice.entities.InventorySecDetailEntity;
import org.tecky.inventoryservice.entities.InventorySecDetailO2MEntity;
import org.tecky.inventoryservice.mapper.InventorySecDetailEntityRepository;
import org.tecky.inventoryservice.mapper.InventorySecDetailO2MRepository;
import org.tecky.inventoryservice.service.intf.InventoryService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventorySecDetailEntityRepository inventorySecDetailEntityRepository;

    @Autowired
    InventorySecDetailO2MRepository inventorySecDetailO2MRepository;

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

    @Override
    public ResponseEntity<?> getRecord(Integer inventoryId) throws JsonProcessingException {

        InventoryQtyRecordDTO inventoryQtyRecordDTO = new InventoryQtyRecordDTO();

        InventorySecDetailO2MEntity inventorySecDetailO2MEntity = inventorySecDetailO2MRepository.findByInventoryId(inventoryId);

        if(inventorySecDetailO2MEntity == null){

            throw new CustomException(404, "InventoryId Not Found");

        }

        inventoryQtyRecordDTO.setInventoryId(inventorySecDetailO2MEntity.getInventoryId());

        List<OnHandQtyRecordDTO> onHandQtyRecordDTOList;
        List<AccQtyRecordDTO> accQtyRecordDTOList;
        List<AvailQtyRecordDTO> availQtyRecordDTOList;

        try {
            
            onHandQtyRecordDTOList = ConversionUtil.convertM2M(OnHandQtyRecordDTO.class, inventorySecDetailO2MEntity.getOnhandDetailM2OEntity());
            accQtyRecordDTOList = ConversionUtil.convertM2M(AccQtyRecordDTO.class, inventorySecDetailO2MEntity.getAccountingDetailM2OEntity());
            availQtyRecordDTOList = ConversionUtil.convertM2M(AvailQtyRecordDTO.class, inventorySecDetailO2MEntity.getAvailableDetailM2OEntity());

        } catch (Exception e) {

            throw new CustomException(500, "Error in InventoryServiceImpl getRecord: ConversionUtil");
        }

        if(onHandQtyRecordDTOList == null) {

            onHandQtyRecordDTOList = new ArrayList<>();
        }

        if(accQtyRecordDTOList == null) {

            accQtyRecordDTOList = new ArrayList<>();
        }

        if(availQtyRecordDTOList == null) {

            availQtyRecordDTOList = new ArrayList<>();
        }

        inventoryQtyRecordDTO.setOnHandQtyRecordDTOList(onHandQtyRecordDTOList);
        inventoryQtyRecordDTO.setAccQtyRecordDTOList(accQtyRecordDTOList);
        inventoryQtyRecordDTO.setAvailQtyRecordDTOList(availQtyRecordDTOList);


        return ResponseObject
                .builder()
                .setObjectPayLoad(inventoryQtyRecordDTO)
                .create(200);
    }
}
