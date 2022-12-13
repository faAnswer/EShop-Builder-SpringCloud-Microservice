package org.tecky.productservice.controller;

import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseListObject;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.productservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/v1/client/categories")
    // return List<CategoryDTO>
    public ResponseEntity<?> getCategories(@RequestParam("clientId") String clienId)  {

        List<CategoryDTO> categoryDTOList;
        ResponseEntity<?> res;

        if(clienId == null) {


            throw new CustomException(400, "clientid not found in url : GET /api/v1/category");
        }

        try{

            categoryDTOList = iCategoryService.getCategories(clienId);

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/category" + e.getMessage());
        }

        if(categoryDTOList == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/category");
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/category" + e.getMessage());
        }

        return res;
    }
    @GetMapping("/v1/categories")
    // return List<CategoryDTO>
    public ResponseEntity<?> getCategories()  {

        List<CategoryDTO> categoryDTOList;
        ResponseEntity<?> res;

        try{

            categoryDTOList = iCategoryService.getCategories();

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/categories" + e.getMessage());
        }

        if(categoryDTOList == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/categories");
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/categories" + e.getMessage());
        }

        return res;
    }

    @GetMapping("/v1/category")
    // return CategoryDTO
    public ResponseEntity<?> getCategory(@RequestParam("categoryId") Integer categoryId, HttpServletRequest request, HttpServletResponse response)  {

        CategoryDTO categoryDTO;
        ResponseEntity<?> res;

        try{

            categoryDTO = iCategoryService.getCategory(categoryId);

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/category" + e.getMessage());
        }

        if(categoryDTO == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/category");
        }

        try{

            res = ResponseObject.builder().setObjectPayLoad(categoryDTO).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/category" + e.getMessage());
        }

        return res;
    }

}
