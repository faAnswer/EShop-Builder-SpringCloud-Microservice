package org.tecky.clientsideservice.controller;

import com.sun.istack.NotNull;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseListObject;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;
import org.tecky.clientsideservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/v1/category")
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

        if(clienId == null) {

            throw new CustomException(400, "clientid is wrong : GET /api/v1/category");
        }

        try{

            res = ResponseListObject.builder().setObjectPayLoad(categoryDTOList).create(200);

        } catch(Exception e){

            throw new CustomException(500, "Error in ResponseEntity : GET /api/v1/category");
        }
        
        return res;
    }
}
