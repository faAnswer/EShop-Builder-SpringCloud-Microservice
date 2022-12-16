package org.tecky.uuaservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostAdminRegDTO;
import org.tecky.common.dto.PostClientRegDTO;
import org.tecky.common.dto.PostRoleDTO;

public interface IAdminService {

    public ResponseEntity<?> adminRegister(PostAdminRegDTO postAdminRegDTO) throws JsonProcessingException;
    public ResponseEntity<?> createRole(PostRoleDTO postRoleDTO) throws JsonProcessingException;

    public ResponseEntity<?> createScope(PostRoleDTO postRoleDTO) throws JsonProcessingException;

    public ResponseEntity<?> delScope(PostRoleDTO postRoleDTO) throws JsonProcessingException;


}
