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
    public ResponseEntity<?> insertProductGroup(PostGroupDTO postGroupDTO) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

        categoryChecker.containsKey()

        GroupEntity groupEntity = ConversionUtil.convertS2S(GroupEntity.class, postGroupDTO);

        try{

            groupEntityRepository.saveAndFlush(groupEntity);

        } catch (Exception e){

            throw new CustomException(500, "Error in Insert Product Group");
        }

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }
}
