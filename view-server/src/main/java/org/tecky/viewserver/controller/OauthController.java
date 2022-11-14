package org.tecky.viewserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/oauth")
public class OauthController {

    @GetMapping("/authorize")
    public ResponseEntity<?> auth(@RequestParam Map<String, String> requestParam, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.add(HttpHeaders.COOKIE, request.getHeader(HttpHeaders.COOKIE));
        HttpEntity<String> request2UAA = new HttpEntity<>(mapper.writeValueAsString(requestParam), headers);

        return restTemplate.exchange("http://47.92.137.0:9001/api/oauth/authorize" + "?" + request.getQueryString() ,HttpMethod.GET, request2UAA, String.class);
    }
}
