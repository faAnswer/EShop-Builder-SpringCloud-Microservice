package org.tecky.clientsideservice.service.intf;

import org.tecky.clientsideservice.entities.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    public List<CategoryEntity> getCategory(String clientId);
}
