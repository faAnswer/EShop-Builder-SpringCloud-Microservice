package org.tecky.productservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tecky.productservice.mapper.CategoryDetailEntityRepository;
import org.tecky.productservice.mapper.TypeDetailEntityRepository;
import org.tecky.productservice.mapper.TypeEntityRepository;
import org.tecky.productservice.service.CategoryChecker;

@Configuration
public class CategoryCheckerConfig {

    @Autowired
    TypeEntityRepository typeEntityRepository;

    @Autowired
    TypeDetailEntityRepository typeDetailEntityRepository;

    @Autowired
    CategoryDetailEntityRepository categoryDetailEntityRepository;

    @Bean
    public CategoryChecker categoryChecker(){

        return new CategoryChecker(typeEntityRepository,
                typeDetailEntityRepository,
                categoryDetailEntityRepository
        );
    }
}
