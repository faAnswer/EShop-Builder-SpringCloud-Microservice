package org.tecky.warehouseservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostWarehouseInShipmentDTO;

public interface IShipmentService {

    public ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO postWarehouseInShipmentDTO) throws JsonProcessingException;
}