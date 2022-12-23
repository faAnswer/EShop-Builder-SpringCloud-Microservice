package org.tecky.orderservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostOrderDTO;

public interface IOrderService {

    public ResponseEntity<?> createOrder(PostOrderDTO postOrderDTO) throws JsonProcessingException;
}
