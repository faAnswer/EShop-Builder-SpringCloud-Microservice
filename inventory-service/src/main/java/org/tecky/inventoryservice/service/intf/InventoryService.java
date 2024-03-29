package org.tecky.inventoryservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostInventoryDTO;

public interface InventoryService {

    public ResponseEntity<?> createInventory(PostInventoryDTO postInventoryDTO) throws JsonProcessingException;

    public ResponseEntity<?> getSummary(Integer productId) throws JsonProcessingException;

    public ResponseEntity<?> getRecord(Integer inventoryId) throws JsonProcessingException;
}