package org.tecky.graphqlservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.tecky.common.dto.InventoryDTO;
import org.tecky.common.dto.InventoryQtyRecordDTO;
import org.tecky.common.dto.InventorySumDTO;
import org.tecky.common.dto.ProductDTO;
import org.tecky.graphqlservice.feign.FeignInventoryServiceAPI;

@Controller
public class InventoryController {

    @Autowired
    FeignInventoryServiceAPI feignInventoryServiceAPI;

    @SchemaMapping
    public InventorySumDTO inventorySum(ProductDTO productDTO) throws JsonProcessingException {

        ResponseEntity<?> res;
        InventorySumDTO inventorySumDTO;

        res = feignInventoryServiceAPI.getQty(productDTO.getProductId());

        inventorySumDTO = (InventorySumDTO) ResponseObject.convert2Object(res);

        return inventorySumDTO;
    }

    @SchemaMapping
    public InventoryQtyRecordDTO inventoryQtyRecordDTO(InventoryDTO inventoryDTO) throws JsonProcessingException {

        ResponseEntity<?> res;
        InventoryQtyRecordDTO inventoryQtyRecordDTO;

        res = feignInventoryServiceAPI.getRecords(inventoryDTO.getInventoryId());

        inventoryQtyRecordDTO = (InventoryQtyRecordDTO) ResponseObject.convert2Object(res);

        return inventoryQtyRecordDTO;
    }
}
