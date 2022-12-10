package org.tecky.uaaservice.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.JSONResponse;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tecky.uaaservice.entities.UserEntity;
import org.tecky.uaaservice.entities.UserRoleEntity;
import org.tecky.uaaservice.mapper.UserEntityRepository;
import org.tecky.uaaservice.mapper.UserRoleEntityRepository;
import org.tecky.uaaservice.services.intf.IRegService;

@Service
public class RegServiceImpl implements IRegService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    UserRoleEntityRepository userRoleEntityRepository;

    @Override
    public ResponseEntity<?> regNewUser(UserEntity userEntity) throws JsonProcessingException {

        UserEntity checkUserEntity;

        checkUserEntity = userEntityRepository.findByUsernameAndClientId(userEntity.getUsername(), userEntity.getClientId());

        if(checkUserEntity != null) {

            throw new CustomException(409, "Username is already in use");
        }

        checkUserEntity = userEntityRepository.findByEmailAndClientId(userEntity.getEmail(), userEntity.getClientId());

        if(checkUserEntity != null) {

            throw new CustomException(409, "Email is already in use");
        }

        userEntity.setShapassword(passwordEncoder.encode(userEntity.getShapassword()));

        userEntityRepository.save(userEntity);

        Integer uid = userEntityRepository.findByUsernameAndClientId(userEntity.getUsername(), userEntity.getClientId()).getUid();
        UserRoleEntity roleEntity = new UserRoleEntity();
        roleEntity.setUid(uid);
        roleEntity.setRoleid(2);
        userRoleEntityRepository.save(roleEntity);

        return ResponseObject
                .builder()
                .setPayLoad("username", userEntity.getUsername())
                .create(200);
    }
}
