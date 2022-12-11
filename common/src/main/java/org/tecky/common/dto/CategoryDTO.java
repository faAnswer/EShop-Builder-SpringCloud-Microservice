package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private int categoryId;
    private String categoryName;
    private String clientId;

    public CategoryDTO(String id) {

        this.clientId = id;
    }
    public CategoryDTO() {
    }
}