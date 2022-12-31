package org.tecky.productservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseListObject;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostGroupDTO;
import org.tecky.common.dto.PostProductDTO;
import org.tecky.common.dto.ProductGroupDTO;
import org.tecky.common.dto.PropertyDTO;
import org.tecky.productservice.entities.GroupDetailEntity;
import org.tecky.productservice.entities.ProductDetailEntity;
import org.tecky.productservice.mapper.GroupDetailEntityRepository;
import org.tecky.productservice.mapper.ProductDetailEntityRepository;
import org.tecky.productservice.service.CategoryChecker;
import org.tecky.productservice.service.intf.IProductService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    GroupDetailEntityRepository groupDetailEntityRepository;

    @Autowired
    CategoryChecker categoryChecker;

    @Autowired
    ProductDetailEntityRepository productDetailEntityRepository;

    @Override
    public ResponseEntity<?> insertProductGroup(PostGroupDTO postGroupDTO) throws JsonProcessingException {

        if(!categoryChecker.containsTypeId(postGroupDTO.getTypeId())){

            throw new CustomException(400, "Error in ProductServiceImpl: Invalid TypeId");
        }
        GroupDetailEntity groupDetailEntity;

        try{

            groupDetailEntity = ConversionUtil.convertS2S(GroupDetailEntity.class, postGroupDTO);

        } catch (Exception e){

            throw new CustomException(500, "Error in ProductServiceImpl insertProductGroup ConversionUtil");
        }

        try{

            groupDetailEntityRepository.saveAndFlush(groupDetailEntity);

        } catch (Exception e){

            throw new CustomException(500, "Error in ProductServiceImpl insertProductGroup saveAndFlush");
        }

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }

    @Override
    public ResponseEntity<?> insertProduct(PostProductDTO postProductDTO) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

        GroupDetailEntity groupDetailEntity = groupDetailEntityRepository.findByGroupId(postProductDTO.getGroupId());

        if(!groupDetailEntity.getClientId().equals(postProductDTO.getClientId())){

            throw new CustomException(400, "Error in ProductServiceImpl insertProduct: Invalid ClientId");
        }

        ProductDetailEntity productDetailEntity = new ProductDetailEntity();

        productDetailEntity.setColaValue(postProductDTO.getColaValue());
        productDetailEntity.setColbValue(postProductDTO.getColbValue());
        productDetailEntity.setGroupId(groupDetailEntity.getGroupId());


        try{

            productDetailEntityRepository.saveAndFlush(productDetailEntity);

        } catch (Exception e){

            throw new CustomException(500, "Error in ProductServiceImpl insertProduct saveAndFlush");
        }


        return ResponseObject
                .builder()
                .setPayLoad("message", "Create successful")
                .create(201);
    }
    @Override
    //ProductGroupDTO
    public ResponseEntity<?> findProductGroup(Integer groupId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

        GroupDetailEntity groupDetailEntity = groupDetailEntityRepository.findByGroupId(groupId);

        if(groupDetailEntity == null || groupDetailEntity.getIsvalid() == 0){

            throw new CustomException(404, "Error in ProductServiceImpl findProductGroup: Validation Product Not Found");
        }

        ProductGroupDTO productGroupDTO = ConversionUtil.convertS2S(ProductGroupDTO.class, groupDetailEntity);

        return ResponseObject
                .builder()
                .setObjectPayLoad(productGroupDTO)
                .create(200);
    }

    @Override
    //List<ProductGroupDTO>
    public ResponseEntity<?> findProductGroupList(String clientId, Integer typeId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

        List<GroupDetailEntity> groupDetailEntityList;
        List<ProductGroupDTO> productGroupDTOList;

        groupDetailEntityList = groupDetailEntityRepository.findByTypeIdAndClientId(typeId, clientId);

        if(groupDetailEntityList == null){

            productGroupDTOList = new ArrayList<>();
        } else {

            productGroupDTOList = ConversionUtil.convertM2M(ProductGroupDTO.class, groupDetailEntityList);
        }

        return ResponseListObject
                .builder()
                .setObjectPayLoad(productGroupDTOList)
                .create(200);
    }

    @Override
    //List<PropertyDTO>
    public ResponseEntity<?> findProductProperties(Integer groupId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {

        List<PropertyDTO> propertyDTOList;

        List<ProductDetailEntity> productDetailEntityList = productDetailEntityRepository.findByGroupId(groupId);

        if(productDetailEntityList == null){

            propertyDTOList = new ArrayList<>();
        } else {

            propertyDTOList = ConversionUtil.convertM2M(PropertyDTO.class, productDetailEntityList);
        }

        return ResponseListObject
                .builder()
                .setObjectPayLoad(propertyDTOList)
                .create(200);
    }
}
