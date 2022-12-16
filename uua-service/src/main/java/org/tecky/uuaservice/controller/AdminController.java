package org.tecky.uuaservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostAdminRegDTO;
import org.tecky.common.dto.PostClientRegDTO;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.service.intf.IAdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    IAdminService iAdminService;

    @PostMapping(value ="/v1/admin/register", consumes = "application/json")
    public ResponseEntity<?> registerAdmin(@Validated @RequestBody PostAdminRegDTO postAdminRegDTO){

        ResponseEntity<?> res;

        try{

            res = iAdminService.adminRegister(postAdminRegDTO);
        } catch (Exception e){

            Integer httpCode = 500;

            if(e instanceof CustomException){

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error in POST/api/v1/client/register" + "\n" + e.getMessage());
        }

        return res;


    }

}
