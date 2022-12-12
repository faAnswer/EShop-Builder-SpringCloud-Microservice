package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private Integer categoryId;
    private String categoryName;
    private String clientId;

    public CategoryDTO(String clientId) {

        this.clientId = clientId;
    }
    public CategoryDTO() {
    }
}