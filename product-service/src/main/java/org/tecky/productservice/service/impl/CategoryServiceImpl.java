package org.tecky.productservice.service.impl;

import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.CategoryTypeDTO;
import org.tecky.productservice.entities.CategoryDetailEntity;
import org.tecky.productservice.entities.TypeDetailEntity;
import org.tecky.productservice.mapper.CategoryDetailEntityRepository;
import org.tecky.productservice.mapper.TypeDetailEntityRepository;
import org.tecky.productservice.service.CategoryChecker;
import org.tecky.productservice.service.intf.ICategoryService;
import org.tecky.common.dto.CategoryDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryDetailEntityRepository categoryDetailEntityRepository;

    @Autowired
    TypeDetailEntityRepository typeDetailEntityRepository;

    @Autowired
    CategoryChecker categoryChecker;


    @Override
    public List<CategoryDTO> getCategory(String clientId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<CategoryDetailEntity> categoryDetailEntityList = categoryDetailEntityRepository.findAllCategoryByClientId(clientId);

        List<CategoryDTO> res = ConversionUtil.convertM2M(CategoryDTO.class, categoryDetailEntityList);

        for(CategoryDTO category: res) {

            category.setClientId(clientId);
        }

        return res;
    }

    @Override
    public List<CategoryDTO> getCategory(){

        List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();

        Map<Integer, String> map = categoryChecker.getCategoryNameMap();

        Set<Integer> keys = map.keySet();

        for(Integer key : keys) {

            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setCategoryId(key);
            categoryDTO.setCategoryName(map.get(key));

            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    @Override
    public List<CategoryTypeDTO> getTypeByCategoryId(Integer categoryId) {

        List<CategoryTypeDTO> categoryTypeDTOList = new ArrayList<>();

        Map<Integer, String> map = categoryChecker.getCategoryTypeFullMap().get(categoryId);

        Set<Integer> keys = map.keySet();

        for(Integer key : keys) {

            CategoryTypeDTO categoryTypeDTO = new CategoryTypeDTO();

            categoryTypeDTO.setTypeId(key);
            categoryTypeDTO.setTypeName(map.get(key));

            categoryTypeDTOList.add(categoryTypeDTO);
        }

        return categoryTypeDTOList;
    }

    @Override
    public List<CategoryTypeDTO> getTypeByCategoryId(Integer categoryId, String clientId) {

        List<CategoryTypeDTO> categoryTypeDTOList;

        List<TypeDetailEntity> typeDetailEntityList = typeDetailEntityRepository.findAllByCategoryIdAndClientId(categoryId, clientId);

        if(typeDetailEntityList.size() == 0){

            return new ArrayList<>();
        }

        try{

            categoryTypeDTOList = ConversionUtil.convertM2M(CategoryTypeDTO.class, typeDetailEntityList);

        } catch(Exception e){

            throw new CustomException(500, "Error in CategoryServiceImpl getTypeByCategoryId");

        }

        return categoryTypeDTOList;

    }
}
