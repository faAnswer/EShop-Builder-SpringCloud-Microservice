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
import org.tecky.common.dto.PostRoleDTO;
import org.tecky.uuaservice.entities.*;
import org.tecky.uuaservice.mapper.*;
import org.tecky.uuaservice.service.intf.IAdminService;

import java.util.List;

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

    @Autowired
    RoleEntityRepository roleEntityRepository;

    @Autowired
    RoleAuthEntityRepository roleAuthEntityRepository;

    @Autowired
    ScopeEntityRepository scopeEntityRepository;

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

    @Override
    public ResponseEntity<?> createRole(PostRoleDTO postRoleDTO) throws JsonProcessingException {

        ClientEntity clientEntity;

        String roleName = postRoleDTO.getRoleName();

        if(roleName.equals("ROOT") || roleName.equals("USER")){

            throw new CustomException(400, "Role name is not allowed: " + roleName);
        }

        clientEntity = clientEntityRepository.findByClientId(postRoleDTO.getClientId());

        if(clientEntity == null){

            throw new CustomException(404, "Target Client ID not found");
        }

        Integer clientUid = clientEntity.getClientUid();

        if(roleEntityRepository
                .findByRoleNameAndClientUid(roleName, clientUid) != null){

            throw new CustomException(409, "Role Name already exists");
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRoleName(roleName);
        roleEntity.setClientUid(clientUid);

        roleEntityRepository.saveAndFlush(roleEntity);

        roleEntity = roleEntityRepository.findByRoleNameAndClientUid(roleName, clientUid);

        createScope(postRoleDTO, roleEntity.getRoleId());

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }

    @Override
    public ResponseEntity<?> createScope(PostRoleDTO postRoleDTO) throws JsonProcessingException {

        ClientEntity clientEntity;

        String roleName = postRoleDTO.getRoleName();

        if(roleName.equals("ROOT") || roleName.equals("USER")){

            throw new CustomException(400, "Scope cannot modify: " + roleName);
        }

        clientEntity = clientEntityRepository.findByClientId(postRoleDTO.getClientId());

        if(clientEntity == null){

            throw new CustomException(404, "Target Client ID not found");
        }

        Integer clientUid = clientEntity.getClientUid();

        RoleEntity roleEntity;
        roleEntity = roleEntityRepository.findByRoleNameAndClientUid(roleName, clientUid);

        if(roleEntity == null){

            throw new CustomException(404, "Target Role not found");
        }

        createScope(postRoleDTO, roleEntity.getRoleId());

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }

    @Override
    public ResponseEntity<?> delScope(PostRoleDTO postRoleDTO) throws JsonProcessingException {

        ClientEntity clientEntity;

        String roleName = postRoleDTO.getRoleName();

        if(roleName.equals("ROOT") || roleName.equals("USER")){

            throw new CustomException(400, "Scope cannot modify: " + roleName);
        }

        clientEntity = clientEntityRepository.findByClientId(postRoleDTO.getClientId());

        if(clientEntity == null){

            throw new CustomException(404, "Target Client ID not found");
        }

        Integer clientUid = clientEntity.getClientUid();

        RoleEntity roleEntity;
        roleEntity = roleEntityRepository.findByRoleNameAndClientUid(roleName, clientUid);

        if(roleEntity == null){

            throw new CustomException(404, "Target Role not found");
        }


        roleAuthEntityRepository.deleteByRoleIdAndScopeIdContains(roleEntity.getRoleId(), postRoleDTO.getScopeIdList());

        return ResponseObject
                .builder()
                .setPayLoad("message", "Delete successful")
                .create(204);
    }

    public void createScope(PostRoleDTO postRoleDTO, Integer roleId) throws JsonProcessingException {

        List<Integer> scopeIdList = postRoleDTO.getScopeIdList();

        for(Integer scopeId : scopeIdList){

            if(scopeEntityRepository.findByScopeId(scopeId) == null){

                throw new CustomException(400, "Scope ID is incorrect");
            }

            RoleAuthEntity roleAuthEntity = new RoleAuthEntity();

            roleAuthEntity.setScopeId(scopeId);
            roleAuthEntity.setRoleId(roleId);

            roleAuthEntityRepository.saveAndFlush(roleAuthEntity);

        }
    }
}
