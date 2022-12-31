package org.tecky.graphqlservice.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.RestTempBuilder;
import org.faAnswer.web.util.json.ResponseListObject;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.tecky.common.dto.*;
import org.tecky.graphqlservice.feign.FeignProductServiceAPI;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    FeignProductServiceAPI feignProductServiceAPI;

    @NacosValue(value = "${product.service}", autoRefreshed = true)
    String productService;

    @QueryMapping
    public ClientDTO clientByClentId(@Argument String clientId) {

        ClientDTO client = new ClientDTO();
        client.setClientId(clientId);

        return client;
    }

    @QueryMapping
    public List<CategoryDTO> categoryList() throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res = feignProductServiceAPI.getCategories();

        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) ResponseListObject.convert2ListObject(res);

        return categoryDTOList;
    }

    @QueryMapping
    public CategoryDTO category(@Argument Integer categoryId) throws JsonProcessingException {

        ResponseEntity<?> res = feignProductServiceAPI.getCategory(categoryId);
        CategoryDTO categoryDTO = (CategoryDTO) ResponseObject.convert2Object(res);

        return categoryDTO;
    }
    @SchemaMapping
    public List<CategoryDTO> category(ClientDTO clientDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res = feignProductServiceAPI.getCategories(clientDTO.getClientId());


        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) ResponseListObject.convert2ListObject(res);

        return categoryDTOList;
    }

    @SchemaMapping
    public List<CategoryTypeDTO> categoryType(CategoryDTO categoryDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res;
        List<CategoryTypeDTO> categoryTypeDTOList;

        if (categoryDTO.getClientId() == null) {

            res = feignProductServiceAPI.getTypes(categoryDTO.getCategoryId());

            categoryTypeDTOList = (List<CategoryTypeDTO>) ResponseListObject.convert2ListObject(res);

        } else {

            res = feignProductServiceAPI.getType(categoryDTO.getCategoryId(), categoryDTO.getClientId());

            categoryTypeDTOList = (List<CategoryTypeDTO>) ResponseListObject.convert2ListObject(res);

            for (CategoryTypeDTO categoryTypeDTO : categoryTypeDTOList) {

                categoryTypeDTO.setClientId(categoryDTO.getClientId());

            }
        }

        return categoryTypeDTOList;
    }

    @SchemaMapping
    public List<ProductGroupDTO> productGroup(CategoryTypeDTO categoryTypeDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res;
        List<ProductGroupDTO> productGroupDTOList;

        res = feignProductServiceAPI.getProductGroupList(categoryTypeDTO.getClientId(), categoryTypeDTO.getTypeId());

        productGroupDTOList = (List<ProductGroupDTO>) ResponseListObject.convert2ListObject(res);

        return productGroupDTOList;
    }

    @SchemaMapping
    public List<PropertyDTO> property(ProductGroupDTO productGroupDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res;
        List<PropertyDTO> propertyDTOList;

        res = feignProductServiceAPI.getProperty(productGroupDTO.getGroupId());

        propertyDTOList = (List<PropertyDTO>) ResponseListObject.convert2ListObject(res);

        return propertyDTOList;
    }

    @SchemaMapping
    public List<SubPropertyDTO> subProperty(PropertyDTO propertyDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res;
        List<SubPropertyDTO> subPropertyDTO;

        res = feignProductServiceAPI.getSubProperty(propertyDTO.getGroupId(), propertyDTO.getColaValue());

        subPropertyDTO = (List<SubPropertyDTO>) ResponseListObject.convert2ListObject(res);

        return subPropertyDTO;
    }

    @SchemaMapping
    public ProductDTO product(SubPropertyDTO subPropertyDTO) throws JsonProcessingException {

        ResponseEntity<?> res;
        ProductDTO productDTO;

        res = feignProductServiceAPI.getProduct(subPropertyDTO.getGroupId(),subPropertyDTO.getColaValue(), subPropertyDTO.getColbValue());

        productDTO = (ProductDTO) ResponseObject.convert2Object(res);

        return productDTO;
    }

}