package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryTypeDTO implements Serializable {

    private Integer typeId;
    private String typeName;

}
