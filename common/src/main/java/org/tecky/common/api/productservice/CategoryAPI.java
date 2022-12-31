package org.tecky.common.api.productservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CategoryAPI {
    @GetMapping("/v1/client/categories")
        // return List<CategoryDTO>
    ResponseEntity<?> getCategories(@RequestParam("clientId") String clienId);

    @GetMapping("/v1/categories")
        // return List<CategoryDTO>
    ResponseEntity<?> getCategories();

    @GetMapping("/v1/category")
        // return CategoryDTO
    ResponseEntity<?> getCategory(@RequestParam("categoryId") Integer categoryId);
}
