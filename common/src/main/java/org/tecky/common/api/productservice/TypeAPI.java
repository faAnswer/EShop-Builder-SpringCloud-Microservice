package org.tecky.common.api.productservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TypeAPI {
    @GetMapping("/v1/types")
        // return List<CategoryTypeDTO>
    ResponseEntity<?> getTypes(@RequestParam("categoryId") Integer categoryId);

    @GetMapping("/v1/type")
        // return List<CategoryTypeDTO>
    ResponseEntity<?> getType(@RequestParam("categoryId") Integer categoryId,
                              @RequestParam("clientId") String clientId);
}
