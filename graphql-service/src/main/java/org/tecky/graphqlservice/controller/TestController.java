package org.tecky.graphqlservice.controller;


import org.faAnswer.web.util.RestTempBuilder;
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

    @QueryMapping
    public ClientDTO clientByClentId(@Argument String id) {

//        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
//                .addPara("clientId", id)
//                .setURL("http://localhost:9052/api/v1/category/")
//                .send(HttpMethod.GET);

        ClientDTO client = new ClientDTO();
        client.setClientId(id);

        return client;
    }

    @SchemaMapping
    public List<CategoryDTO> categoryType(ClientDTO clientDTO) {

        ResponseEntity<?> res = new RestTempBuilder(MediaType.APPLICATION_JSON)
                .addPara("clientId", clientDTO.getClientId())
                .setURL("http://localhost:9052/api/v1/category/")
                .send(HttpMethod.GET);


        return Author.getById(book.getAuthorId());
    }
}