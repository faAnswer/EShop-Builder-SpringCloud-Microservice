package org.tecky.productservice.service.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.tecky.common.dto.PostGroupDTO;

import java.lang.reflect.InvocationTargetException;

public interface IProductService {

    public ResponseEntity<?> insertProductGroup(PostGroupDTO postGroupDTO) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException;
}
