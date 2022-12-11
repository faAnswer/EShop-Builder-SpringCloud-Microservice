package org.tecky.clientsideservice.service.impl;

import lombok.Data;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tecky.clientsideservice.entities.CategoryDetailEntity;
import org.tecky.clientsideservice.entities.TypeListEntity;
import org.tecky.clientsideservice.mapper.CategoryDetailEntityRepository;
import org.tecky.clientsideservice.mapper.TypeListEntityRepository;
import org.tecky.clientsideservice.service.intf.ICategoryService;
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
