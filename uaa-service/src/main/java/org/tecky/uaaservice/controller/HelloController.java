package org.tecky.uaaservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello World";
    }

}
