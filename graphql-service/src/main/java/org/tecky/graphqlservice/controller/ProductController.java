package org.tecky.graphqlservice.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.RestTempBuilder;
import org.faAnswer.web.util.json.ResponseListObject;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.tecky.common.dto.CategoryDTO;
import org.tecky.common.dto.CategoryTypeDTO;
import org.tecky.common.dto.ClientDTO;

import java.util.List;

@Controller
public class ProductController {

    @NacosValue(value = "${product.service}", autoRefreshed = true)
    String productService;

    @QueryMapping
    public ClientDTO clientByClentId(@Argument String clientId) {

//        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
//                .addPara("clientId", id)
//                .setURL("http://localhost:9052/api/v1/category/")
//                .send(HttpMethod.GET);

        ClientDTO client = new ClientDTO();
        client.setClientId(clientId);

        return client;
    }

    @QueryMapping
    public List<CategoryDTO> categoryList() throws JsonProcessingException, ClassNotFoundException{

        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                .setURL(this.productService + "api/v1/categories/")
                .send(HttpMethod.GET);

        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) ResponseListObject.convert2ListObject(res);

        return categoryDTOList;
    }

    @QueryMapping
    public ClientDTO category(@Argument String clientId) {

//        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
//                .addPara("clientId", id)
//                .setURL("http://localhost:9052/api/v1/category/")
//                .send(HttpMethod.GET);

        ClientDTO client = new ClientDTO();
        client.setClientId(clientId);

        return client;
    }

    @SchemaMapping
    public List<CategoryDTO> category(ClientDTO clientDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                .addPara("clientId", clientDTO.getClientId())
                .setURL(this.productService + "api/v1/client/categories/")
                .send(HttpMethod.GET);

        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) ResponseListObject.convert2ListObject(res);

        return categoryDTOList;
    }

    @SchemaMapping
    public List<CategoryTypeDTO> categoryType(CategoryDTO categoryDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res;
        List<CategoryTypeDTO> categoryTypeDTOList;

        if(categoryDTO.getClientId() == null){

            res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                    .addPara("categoryId", categoryDTO.getCategoryId())
                    .setURL(this.productService + "api/v1/types/")
                    .send(HttpMethod.GET);

            categoryTypeDTOList = (List<CategoryTypeDTO>) ResponseListObject.convert2ListObject(res);

        } else {

            res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                    .addPara("categoryId", categoryDTO.getCategoryId())
                    .addPara("clientId", categoryDTO.getClientId())
                    .setURL(this.productService + "api/v1/type/")
                    .send(HttpMethod.GET);


            categoryTypeDTOList = (List<CategoryTypeDTO>) ResponseListObject.convert2ListObject(res);

            for(CategoryTypeDTO categoryTypeDTO: categoryTypeDTOList){

                categoryTypeDTO.setClientId(categoryDTO.getClientId());

            }
        }

        return categoryTypeDTOList;
    }
}
