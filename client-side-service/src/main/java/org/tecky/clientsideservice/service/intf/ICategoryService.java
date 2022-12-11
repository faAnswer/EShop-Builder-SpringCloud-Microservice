package org.tecky.clientsideservice.service.intf;

import org.tecky.clientsideservice.entities.TypeListEntity;
import org.tecky.common.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getCategory(String clientId);
}
