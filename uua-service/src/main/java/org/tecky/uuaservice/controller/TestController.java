package org.tecky.uuaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.uuaservice.entities.compk.RoleAuthEntityPK;
import org.tecky.uuaservice.mapper.RoleAuthEntityRepository;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    RoleAuthEntityRepository roleAuthEntityRepository;

    @GetMapping("/v1/test")
    public String getTest(){
        RoleAuthEntityPK roleAuthEntityPK = new RoleAuthEntityPK();
        roleAuthEntityPK.setRoleId(1);
        roleAuthEntityPK.setClientUid(5);

        return "test";
    }
}
