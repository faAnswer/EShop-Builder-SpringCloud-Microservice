package org.tecky.clientsideservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.tecky.clientsideservice.entities.CategoryEntity;
import org.tecky.clientsideservice.mapper.CategoryEntityRepository;
import org.tecky.clientsideservice.service.intf.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Override
    public List<CategoryEntity> getCategory(String clientId) {

        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findByClientId(clientId);







        return null;
    }
}
