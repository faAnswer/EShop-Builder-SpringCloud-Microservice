package org.tecky.inventoryservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostInventoryDTO;

public interface InventoryService {

    public ResponseEntity<?> createInventory(PostInventoryDTO postInventoryDTO) throws JsonProcessingException;
}
