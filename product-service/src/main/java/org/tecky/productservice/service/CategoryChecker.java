package org.tecky.productservice.service;

import lombok.Getter;
import org.faAnswer.web.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tecky.productservice.entities.CategoryDetailEntity;
import org.tecky.productservice.entities.TypeDetailEntity;
import org.tecky.productservice.entities.TypeEntity;
import org.tecky.productservice.mapper.CategoryDetailEntityRepository;
import org.tecky.productservice.mapper.TypeDetailEntityRepository;
import org.tecky.productservice.mapper.TypeEntityRepository;

import java.util.*;

@Getter
public class CategoryChecker {

    private TypeEntityRepository typeEntityRepository;

    private TypeDetailEntityRepository typeDetailEntityRepository;

    private CategoryDetailEntityRepository categoryDetailEntityRepository;

    //    V:TypeId, K: CategoryId
    private Map<Integer, Integer> typeMap = new HashMap<Integer, Integer>();

    //    K: TypeId, V:TypeName

    private Map<Integer, String> typeNameMap = new HashMap<Integer, String>();

    //    K: CategoryId, V:CategoryName

    private Map<Integer, String> categoryNameMap = new HashMap<Integer, String>();

    private Map<String, List<String>> categoryTypeNameMap = new HashMap<>();

    private Map<Integer, List<Integer>> categoryTypeIdMap = new HashMap<>();

    private Map<Integer, Map<Integer, String>> categoryTypeFullMap = new HashMap<>();



    public CategoryChecker(TypeEntityRepository typeEntityRepository,
                           TypeDetailEntityRepository typeDetailEntityRepository,
                           CategoryDetailEntityRepository categoryDetailEntityRepository
                           ){

        this.typeEntityRepository = typeEntityRepository;
        this.typeDetailEntityRepository = typeDetailEntityRepository;
        this.categoryDetailEntityRepository = categoryDetailEntityRepository;

        //
        List<CategoryDetailEntity> categoryDetailEntityList = this.categoryDetailEntityRepository.findAll();

        for(CategoryDetailEntity categoryDetailEntity : categoryDetailEntityList){

            this.categoryNameMap.put(categoryDetailEntity.getCategoryId(), categoryDetailEntity.getCategoryName());

            this.categoryTypeNameMap.put(categoryDetailEntity.getCategoryName(), new ArrayList<>());
            this.categoryTypeIdMap.put(categoryDetailEntity.getCategoryId(), new ArrayList<>());
            this.categoryTypeFullMap.put(categoryDetailEntity.getCategoryId(), new HashMap<>());

        }

        //
        List<TypeEntity> typeEntityList = this.typeEntityRepository.findAllValidType();

        for(TypeEntity typeEntity : typeEntityList){

            this.typeMap.put(typeEntity.getTypeId(), typeEntity.getCategoryId());

            List<Integer> arrayList = this.categoryTypeIdMap.get(typeEntity.getCategoryId());
            arrayList.add(typeEntity.getTypeId());
        }

        //
        List<TypeDetailEntity> typeDetailEntityList = this.typeDetailEntityRepository.findAll();

        for(TypeDetailEntity typeDetailEntity : typeDetailEntityList){

            this.typeNameMap.put(typeDetailEntity.getTypeId(), typeDetailEntity.getTypeName());

            Integer categoryId = this.typeMap.get(typeDetailEntity.getTypeId());
            String categoryName = this.categoryNameMap.get(categoryId);

            List<String> arrayList = this.categoryTypeNameMap.get(categoryName);
            arrayList.add(typeDetailEntity.getTypeName());

            Map<Integer, String> map = this.categoryTypeFullMap.get(categoryId);

            map.put(typeDetailEntity.getTypeId(), typeDetailEntity.getTypeName());
        }
    }

    public boolean containsTypeId(Integer typeId){

        return this.typeNameMap.containsKey(typeId);

    }

    public boolean containsCategoryId(Integer categoryId){

        return this.categoryNameMap.containsKey(categoryId);

    }

    public String typeName(Integer typeId){

        if(this.containsTypeId(typeId)){

            return this.typeNameMap.get(typeId);

        } else {

            throw new CustomException(400, "TypeId Invalid: " + typeId);
        }
    }
    public String categoryName(Integer categoryId){

        if(this.containsCategoryId(categoryId)){

            return this.categoryNameMap.get(categoryId);

        } else {

            throw new CustomException(400, "CategoryId Invalid: " + categoryId);
        }
    }
}
