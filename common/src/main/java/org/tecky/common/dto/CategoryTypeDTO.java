package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryTypeDTO implements Serializable {

    private Integer typeId;
    private String typeName;
    private String clientId;

    public CategoryTypeDTO(String clientId) {

        this.clientId = clientId;
    }
    public CategoryTypeDTO() {
    }
}
