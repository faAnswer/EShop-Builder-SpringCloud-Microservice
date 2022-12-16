package org.tecky.uuaservice.controller;

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

@RestController
@RequestMapping("/api")
public class AdminController {

    @PostMapping("/v1/admin/register")
    public ResponseEntity<?> registerAdmin(@Validated @RequestBody PostAdminRegDTO postAdminRegDTO){

        ResponseEntity<?> res;

        public ClientSecUserEntity findByClientIdAndEmail(@Param("clientId") String clientId, @Param("email") String email);



    }

}
