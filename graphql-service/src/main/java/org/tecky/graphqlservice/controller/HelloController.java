package org.tecky.graphqlservice.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @NacosValue(value = "${product-service:string}", autoRefreshed = true)
    String productService;

    @GetMapping("/hello")
    public String getHello(){

        return productService;
    }
}
