package org.tecky.orderservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.tecky.mvcwebcommon.filter.SeataFilter;
import org.tecky.mvcwebcommon.interceptor.SeataRestTemplateInterceptor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Configuration
public class SeataRestTemplateConfiguration {

    @Bean
    public SeataFilter seataFilter(){

        return new SeataFilter();
    }

    @Bean
    public SeataRestTemplateInterceptor seataRestTemplateInterceptor() {
        return new SeataRestTemplateInterceptor();
    }
}
