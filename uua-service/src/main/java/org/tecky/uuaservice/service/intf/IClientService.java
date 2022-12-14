package org.tecky.uuaservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostClientRegDTO;

public interface IClientService {

    public ResponseEntity<?> clientRegister(PostClientRegDTO postClientRegDTO) throws JsonProcessingException;
}
