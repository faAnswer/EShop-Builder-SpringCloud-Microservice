package org.tecky.graphqlservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.tecky.common.dto.InventorySumDTO;
import org.tecky.common.dto.ProductDTO;
import org.tecky.common.dto.SubPropertyDTO;
import org.tecky.graphqlservice.feign.FeignInventoryServiceAPI;
import org.tecky.graphqlservice.feign.FeignProductServiceAPI;

@Controller
public class InventoryController {

    @Autowired
    FeignInventoryServiceAPI feignInventoryServiceAPI;

    @SchemaMapping
    public InventorySumDTO inventorySum(ProductDTO productDTO) throws JsonProcessingException {

        ResponseEntity<?> res;
        InventorySumDTO inventorySumDTO;

        res = feignInventoryServiceAPI.getSummary(productDTO.getProductId());

        inventorySumDTO = (InventorySumDTO) ResponseObject.convert2Object(res);

        return inventorySumDTO;
    }
}
