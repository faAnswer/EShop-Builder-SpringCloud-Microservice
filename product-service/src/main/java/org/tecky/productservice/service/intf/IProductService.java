package org.tecky.productservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostGroupDTO;
import org.tecky.common.dto.PostProductDTO;

import java.lang.reflect.InvocationTargetException;

public interface IProductService {

    public ResponseEntity<?> insertProductGroup(PostGroupDTO postGroupDTO) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException;

    public ResponseEntity<?> insertProduct(PostProductDTO postProductDTO) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException;

    public ResponseEntity<?> findProductGroup(Integer groupId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException;

}
