package org.tecky.uuaservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostClientLoginDTO;
import org.tecky.common.dto.PostClientRegDTO;

public interface IUserService {

    public ResponseEntity<?> rootRegister(PostClientRegDTO postClientRegDTO) throws JsonProcessingException;
    public ResponseEntity<?> clientLogin(PostClientLoginDTO postClientLoginDTO) throws JsonProcessingException;

}
