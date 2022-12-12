package org.tecky.productservice.service.intf;

import org.tecky.common.dto.CategoryDTO;
import org.tecky.common.dto.CategoryTypeDTO;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getCategory(String clientId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    public List<CategoryDTO> getCategory() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    public List<CategoryTypeDTO> getTypeByCategoryId(Integer categoryId);
    public List<CategoryTypeDTO> getTypeByCategoryId(Integer categoryId, String clientId);


}
