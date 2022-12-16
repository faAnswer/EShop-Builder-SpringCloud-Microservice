package org.tecky.uuaservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tecky.common.dto.PostAdminRegDTO;
import org.tecky.common.dto.PostRoleDTO;
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
            throw new CustomException(httpCode, "Error in POST/api/v1/admin/register" + "\n" + e.getMessage());
        }

        return res;
    }

    @PostMapping(value ="/v1/admin/role", consumes = "application/json")
    public ResponseEntity<?> createRole(@Validated @RequestBody PostRoleDTO postRoleDTO){

        ResponseEntity<?> res;

        try{

            res = iAdminService.createRole(postRoleDTO);
        } catch (Exception e){

            Integer httpCode = 500;

            if(e instanceof CustomException){

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error in POST/api/v1/admin/role" + "\n" + e.getMessage());
        }

        return res;
    }

    @PostMapping(value ="/v1/admin/scope", consumes = "application/json")
    public ResponseEntity<?> createScope(@Validated @RequestBody PostRoleDTO postRoleDTO){

        ResponseEntity<?> res;

        try{

            res = iAdminService.createScope(postRoleDTO);
        } catch (Exception e){

            Integer httpCode = 500;

            if(e instanceof CustomException){

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error in POST/api/v1/admin/scope" + "\n" + e.getMessage());
        }

        return res;
    }
    @DeleteMapping(value ="/v1/admin/scope", consumes = "application/json")
    public ResponseEntity<?> delScope(@Validated @RequestBody PostRoleDTO postRoleDTO){

        ResponseEntity<?> res;

        try{

            res = iAdminService.delScope(postRoleDTO);
        } catch (Exception e){

            Integer httpCode = 500;

            if(e instanceof CustomException){

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error in DELETE/api/v1/admin/scope" + "\n" + e.getMessage());
        }

        return res;
    }
}
