package org.tecky.graphqlservice.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.faAnswer.web.util.RestTempBuilder;
import org.faAnswer.web.util.json.ResponseListObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.tecky.common.dto.CategoryDTO;
import org.tecky.common.dto.ClientDTO;

import java.util.List;

@Controller
public class TestController {

    @NacosValue(value = "${product-service:string}", autoRefreshed = true)
    private String productService;

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

    @SchemaMapping
    public List<CategoryDTO> category(ClientDTO clientDTO) throws JsonProcessingException, ClassNotFoundException {

        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                .addPara("clientId", clientDTO.getClientId())
                .setURL(this.productService + "api/v1/category/")
                .send(HttpMethod.GET);

        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) ResponseListObject.convert2ListObject(res);

        return categoryDTOList;
    }

}