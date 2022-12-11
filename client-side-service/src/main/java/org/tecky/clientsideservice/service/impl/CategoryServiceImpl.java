package org.tecky.clientsideservice.service.impl;

import lombok.Data;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.tecky.clientsideservice.entities.CategoryDetailEntity;
import org.tecky.clientsideservice.entities.TypeListEntity;
import org.tecky.clientsideservice.mapper.CategoryDetailEntityRepository;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;
import org.tecky.clientsideservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryDetailEntityRepository categoryDetailEntityRepository;

    @Override
    public List<CategoryDTO> getCategory(String clientId) {

        List<CategoryDetailEntity> categoryDetailEntityList = categoryDetailEntityRepository.findAllCategoryByClientId(clientId);

//        ResponseObject.builder().


        return null;
    }
}
