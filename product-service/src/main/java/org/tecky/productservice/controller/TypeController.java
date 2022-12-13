package org.tecky.productservice.controller;

import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseListObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.CategoryDTO;
import org.tecky.common.dto.CategoryTypeDTO;
import org.tecky.productservice.service.intf.ICategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/v1/types")
    // return List<CategoryTypeDTO>
    public ResponseEntity<?> getTypes(@RequestParam("categoryId") Integer categoryId)  {

        List<CategoryTypeDTO> categoryTypeDTOList;
        ResponseEntity<?> res;

        if(categoryId == null) {

            throw new CustomException(400, "categoryId not found in url : GET /api/v1/types");
        }

        try{

            categoryTypeDTOList = iCategoryService.getTypeByCategoryId(categoryId);

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/types" + e.getMessage());
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryTypeDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/types" + e.getMessage());
        }

        return res;
    }

    @GetMapping("/v1/type")
    // return List<CategoryTypeDTO>
    public ResponseEntity<?> getType(@RequestParam("categoryId") Integer categoryId,
                                     @RequestParam("clientId") String clientId)  {

        List<CategoryTypeDTO> categoryTypeDTOList;
        ResponseEntity<?> res;

        if(categoryId == null) {


            throw new CustomException(400, "categoryId not found in url : GET /api/v1/type");
        }

        if(clientId == null) {


            throw new CustomException(400, "clientId not found in url : GET /api/v1/type");
        }

        try{

            categoryTypeDTOList = iCategoryService.getTypeByCategoryId(categoryId, clientId);

        } catch(Exception e){

            throw new CustomException(500, "Error in Service : GET /api/v1/type" + e.getMessage());
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryTypeDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/type" + e.getMessage());
        }

        return res;
    }
}
