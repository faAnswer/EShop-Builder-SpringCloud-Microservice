package org.tecky.common.api.productservice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.dto.PostGroupDTO;
import org.tecky.common.dto.PostProductDTO;

public interface ProductGroupAPI {
    @PostMapping(value = "/v1/products", consumes = "application/json")
    ResponseEntity<?> postGroup(@RequestBody @Validated PostGroupDTO postGroupDTO);

    @PostMapping(value = "/v1/product", consumes = "application/json")
    ResponseEntity<?> postProduct(@RequestBody @Validated PostProductDTO postProductDTO);

    @GetMapping(value = "/v1/products/{clientId}/{typeId}")
    ResponseEntity<?> getProductGroupList(@PathVariable("clientId") String clientId,
                                          @PathVariable("typeId") Integer typeId);

    @GetMapping(value = "/v1/products")
    ResponseEntity<?> getProducts(@RequestParam("groupId") Integer groupId);

    @GetMapping(value = "/v1/property")
    ResponseEntity<?> getProperty(@RequestParam("groupId") Integer groupId);

    @GetMapping(value = "/v1/subproperty")
    ResponseEntity<?> getSubProperty(@RequestParam("groupId") Integer groupId, @RequestParam("p") String p);

    @GetMapping(value = "/v1/product", params = {"groupId", "p", "s"})
    ResponseEntity<?> getProduct(@RequestParam("groupId") Integer groupId, @RequestParam("p") String p, @RequestParam("s") String s);

    @GetMapping(value = "/v1/product", params = {"productId"})
    ResponseEntity<?> getProduct(@RequestParam("productId") Integer productId);
}
