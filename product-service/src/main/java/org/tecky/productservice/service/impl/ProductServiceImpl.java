package org.tecky.productservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostGroupDTO;
import org.tecky.productservice.entities.GroupEntity;
import org.tecky.productservice.mapper.GroupEntityRepository;
import org.tecky.productservice.service.CategoryChecker;
import org.tecky.productservice.service.intf.IProductService;

import java.lang.reflect.InvocationTargetException;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    GroupEntityRepository groupEntityRepository;

    @Autowired
    CategoryChecker categoryChecker;

    @Override
    public ResponseEntity<?> insertProductGroup(PostGroupDTO postGroupDTO) throws JsonProcessingException {

        if(!categoryChecker.containsCategoryId(postGroupDTO.getTypeId())){

            throw new CustomException(400, "Error in ProductServiceImpl: Invalid TypeId");
        }
        GroupEntity groupEntity;

        try{

            groupEntity = ConversionUtil.convertS2S(GroupEntity.class, postGroupDTO);

        } catch (Exception e){

            throw new CustomException(500, "Error in ProductServiceImpl insertProductGroup ConversionUtil");
        }

        try{

            groupEntityRepository.saveAndFlush(groupEntity);

        } catch (Exception e){

            throw new CustomException(500, "Error in ProductServiceImpl insertProductGroup saveAndFlush");
        }

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }
}
