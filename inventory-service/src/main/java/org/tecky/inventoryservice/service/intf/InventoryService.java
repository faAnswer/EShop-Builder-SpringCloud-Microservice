package org.tecky.inventoryservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostInventoryDTO;

public interface InventoryService {

    public ResponseEntity<?> createInventory(PostInventoryDTO postInventoryDTO) throws JsonProcessingException;

    public ResponseEntity<?> getSummary(Integer productId) throws JsonProcessingException;

    public ResponseEntity<?> getAvailRecord(Integer inventoryId) throws JsonProcessingException;

    public ResponseEntity<?> getAccRecord(Integer inventoryId) throws JsonProcessingException;

    public ResponseEntity<?> getOnHandRecord(Integer inventoryId) throws JsonProcessingException;




}
