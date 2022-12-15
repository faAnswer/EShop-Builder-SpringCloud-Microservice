package org.tecky.uuaservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.jwt.JWTUtil;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostClientLoginDTO;
import org.tecky.common.dto.PostClientRegDTO;
import org.tecky.uuaservice.entities.ClientSecUserEntity;
import org.tecky.uuaservice.mapper.ClientEntityRepository;
import org.tecky.uuaservice.mapper.ClientSecUserEntityRepository;
import org.tecky.uuaservice.mapper.UserEntityRepository;
import org.tecky.uuaservice.security.CustomUserDetailsService;
import org.tecky.uuaservice.service.intf.IClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ClientServiceImpl implements IClientService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    ClientEntityRepository clientEntityRepository;

    @Autowired
    ClientSecUserEntityRepository clientSecUserEntityRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<?> rootRegister(PostClientRegDTO postClientRegDTO) throws JsonProcessingException {

        ClientSecUserEntity clientSecUserEntity;

        if(clientEntityRepository.findByClientId(postClientRegDTO.getClientId()) != null){

            throw new CustomException(409, "Client ID is already registered");
        }

        if(clientEntityRepository.findByClientName(postClientRegDTO.getClientName()) != null){

            throw new CustomException(409, "Client Name is already registered");
        }

        if(userEntityRepository.findByEmailAndRoleId(postClientRegDTO.getEmail(), 1) != null){

            throw new CustomException(409, "Email is already registered");
        }

        if(userEntityRepository.findByUsernameAndRoleId(postClientRegDTO.getUsername(), 1) != null){

            throw new CustomException(409, "Username is already registered");
        }

        try {

            clientSecUserEntity = ConversionUtil.convertS2S(ClientSecUserEntity.class, postClientRegDTO);
        } catch (Exception e) {

            throw new CustomException(500, "Error in ClientServiceImpl clientRegister: ConversionUtil/" + e.getMessage());
        }

        clientSecUserEntity.setShapassword(passwordEncoder.encode(postClientRegDTO.getPassword()));
        clientSecUserEntity.setRoleId(1);

        clientSecUserEntityRepository.saveAndFlush(clientSecUserEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Registration successful")
                .create(201);
    }

    @Override
    public ResponseEntity<?> clientLogin(PostClientLoginDTO postClientLoginDTO) throws JsonProcessingException {

        this.customUserDetailsService.setClientId(postClientLoginDTO.getClientId());
        UsernamePasswordAuthenticationToken authentication;
        try{

            authentication = (UsernamePasswordAuthenticationToken) authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(postClientLoginDTO.getEmail(),
                            postClientLoginDTO.getPassword()));

        } catch (Exception e){

            throw new CustomException(401, "Username or password incorrect");
        }

        ClientSecUserEntity clientSecUserEntity = clientSecUserEntityRepository
                .findByClientIdAndEmail(postClientLoginDTO.getClientId(), postClientLoginDTO.getEmail());

        List<String> scopeList = new ArrayList<>();

        authentication.getAuthorities()
                .forEach(element -> scopeList.add(element.getAuthority()));

        String jwt = JWTUtil
                .builder(this.jwtSecret)
                .setPayload("username", clientSecUserEntity.getUsername())
                .setPayload("uid", clientSecUserEntity.getUid())
                .setPayload("clientId", clientSecUserEntity.getClientId())
                .setPayload("clientUid", clientSecUserEntity.getClientUid())
                .setPayload("scope", scopeList)
                .generateToken();

        return ResponseObject
                .builder()
                .setPayLoad("username", clientSecUserEntity.getUsername())
                .setPayLoad("Authentication", jwt)
                .create(200);
    }
}
