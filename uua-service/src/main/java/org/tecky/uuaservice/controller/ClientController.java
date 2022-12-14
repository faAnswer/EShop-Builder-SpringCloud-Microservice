package org.tecky.uuaservice.controller;

import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.common.dto.PostClientLoginDTO;
import org.tecky.common.dto.PostClientRegDTO;
import org.tecky.uuaservice.service.intf.IClientService;

@RestController
@RequestMapping("/admin/api")
public class ClientController {

    @Autowired
    IClientService iClientService;

    @PostMapping(value = "/v1/register", consumes = "application/json")
    public ResponseEntity<?> register(@Validated @RequestBody PostClientRegDTO postClientRegDTO){

        ResponseEntity<?> res;

        try{

            res = iClientService.rootRegister(postClientRegDTO);
        } catch (Exception e){

            Integer httpCode = 500;

            if(e instanceof CustomException){

                httpCode = ((CustomException) e).getCode();
            }
            throw new CustomException(httpCode, "Error in POST/v1/client/register" + "\n" + e.getMessage());
        }

        return res;
    }
//
//    @PostMapping(value = "/v1/login", consumes = "application/json")
//    public ResponseEntity<?> login(@Validated @RequestBody PostClientLoginDTO postClientLoginDTO){
//
//        ResponseEntity<?> res;
//
//        try{
//
//            res = iClientService.clientRegister(postClientRegDTO);
//        } catch (Exception e){
//
//            Integer httpCode = 500;
//
//            if(e instanceof CustomException){
//
//                httpCode = ((CustomException) e).getCode();
//            }
//            throw new CustomException(httpCode, "Error in POST/v1/client/register" + "\n" + e.getMessage());
//        }
//
//        return res;
//    }


}
