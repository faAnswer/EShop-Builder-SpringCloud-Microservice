package org.tecky.common.api.inventoryservice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.tecky.common.dto.PostInventoryDTO;

public interface InventoryAPI {
    @PostMapping(value = "/v1/inventory", consumes = "application/json")
    ResponseEntity<?> postInventory(@RequestBody @Validated PostInventoryDTO postInventoryDTO);

    @GetMapping(value = "/v1/qty", params = {"productId"})
    ResponseEntity<?> getQty(@RequestParam("productId") Integer productId);

    @GetMapping(value = "/v1/records", params = {"inventoryId"})
    ResponseEntity<?> getRecords(@RequestParam("inventoryId") Integer inventoryId);

}
