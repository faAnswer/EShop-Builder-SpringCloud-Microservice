package org.tecky.warehouseservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostWarehouseDTO;

import javax.servlet.http.HttpServletRequest;

public interface IWarehouseService {

    public ResponseEntity<?> createWarehouse(PostWarehouseDTO postWarehouseDTO) throws JsonProcessingException;
}
