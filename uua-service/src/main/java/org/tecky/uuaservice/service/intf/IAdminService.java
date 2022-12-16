package org.tecky.uuaservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostAdminRegDTO;
import org.tecky.common.dto.PostClientRegDTO;

public interface IAdminService {

    public ResponseEntity<?> adminRegister(PostAdminRegDTO postAdminRegDTO) throws JsonProcessingException;

}
