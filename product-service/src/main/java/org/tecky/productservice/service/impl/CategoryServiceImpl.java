package org.tecky.productservice.service.impl;

import org.faAnswer.web.util.dto.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tecky.productservice.entities.CategoryDetailEntity;
import org.tecky.productservice.mapper.CategoryDetailEntityRepository;
import org.tecky.productservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryDetailEntityRepository categoryDetailEntityRepository;

    @Override
    public List<CategoryDTO> getCategory(String clientId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<CategoryDetailEntity> categoryDetailEntityList = categoryDetailEntityRepository.findAllCategoryByClientId(clientId);

        List<CategoryDTO> res = ConversionUtil.convertM2M(CategoryDTO.class, categoryDetailEntityList);

        for(CategoryDTO category: res) {

            category.setClientId(clientId);
        }

        return res;
    }
}