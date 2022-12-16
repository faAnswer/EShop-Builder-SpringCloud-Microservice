package org.tecky.uuaservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostAdminRegDTO;
import org.tecky.uuaservice.entities.ClientEntity;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.entities.UserEntity;
import org.tecky.uuaservice.mapper.ClientEntityRepository;
import org.tecky.uuaservice.mapper.ClientSecUserEntityRepository;
import org.tecky.uuaservice.mapper.UserEntityRepository;
import org.tecky.uuaservice.service.intf.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientEntityRepository clientEntityRepository;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    ClientSecUserEntityRepository clientSecUserEntityRepository;

    @Override
    public ResponseEntity<?> adminRegister(PostAdminRegDTO postAdminRegDTO) throws JsonProcessingException {

        UserEntity userEntity;
        ClientEntity clientEntity;

        clientEntity = clientEntityRepository.findByClientId(postAdminRegDTO.getClientId());

        if(clientEntity == null){

            throw new CustomException(400, "Invalid Client ID");
        }

        if(clientSecUserEntityRepository
                .findByClientIdAndEmail(postAdminRegDTO.getClientId(), postAdminRegDTO.getEmail())!= null){

            throw new CustomException(409, "Email is already registered");
        }

        if(clientSecUserEntityRepository
                .findByClientIdAndUsername(postAdminRegDTO.getClientId(), postAdminRegDTO.getUsername())!= null){

            throw new CustomException(409, "Username is already registered");
        }

        try {

            userEntity = ConversionUtil.convertS2S(UserEntity.class, postAdminRegDTO);
        } catch (Exception e) {

            throw new CustomException(500, "Error in AdminServiceImpl adminRegister: ConversionUtil" + "\n" + e.getMessage());
        }


        userEntity.setClientUid(clientEntity.getClientUid());
        userEntity.setShapassword(this.passwordEncoder.encode(postAdminRegDTO.getPassword()));

        userEntityRepository.saveAndFlush(userEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Registration successful")
                .create(201);
    }
}
