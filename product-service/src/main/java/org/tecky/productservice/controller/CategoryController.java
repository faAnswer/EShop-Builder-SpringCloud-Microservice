package org.tecky.productservice.controller;

import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseListObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/v1/category")
    // return List<CategoryDTO>
    public ResponseEntity<?> getCategory(@RequestParam("clientId") String clienId, HttpServletRequest request, HttpServletResponse response)  {

        List<CategoryDTO> categoryDTOList;
        ResponseEntity<?> res;

        if(clienId == null) {


            throw new CustomException(400, "clientid not found in url : GET /api/v1/category");
        }

        try{

            categoryDTOList = iCategoryService.getCategory(clienId);

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/category");
        }

        if(categoryDTOList == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/category");
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/category");
        }

        return res;
    }
    @GetMapping("/v1/categories")
    // return List<CategoryDTO>
    public ResponseEntity<?> getCategory()  {

        List<CategoryDTO> categoryDTOList;
        ResponseEntity<?> res;

        try{

            categoryDTOList = iCategoryService.getCategory();

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/categories");
        }

        if(categoryDTOList == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/categories");
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/categories");
        }

        return res;
    }
}
