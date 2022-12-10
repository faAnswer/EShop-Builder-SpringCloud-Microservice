package org.tecky.uaaservice.services.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.json.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.uaaservice.entities.UserEntity;

public interface IRegService {

    public ResponseEntity<?> regNewUser(UserEntity userEntity) throws JsonProcessingException;


}
