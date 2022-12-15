package org.tecky.uuaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity;
import org.tecky.uuaservice.entities.ScopeEntity;
import org.tecky.uuaservice.entities.compk.RoleAuthEntityPK;
import org.tecky.uuaservice.entities.compk.TestPK;
import org.tecky.uuaservice.mapper.RoleAuthEntityRepository;
import org.tecky.uuaservice.mapper.RoleAuthS2OScopeEntityRepository;
import org.tecky.uuaservice.mapper.RoleEntityRepository;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    RoleAuthS2OScopeEntityRepository roleAuthS2OScopeEntityRepository;
    @Autowired
    RoleAuthEntityRepository roleAuthEntityRepository;
    @GetMapping("/v1/test")
    public String getTest(){



        return "test";
    }
}
