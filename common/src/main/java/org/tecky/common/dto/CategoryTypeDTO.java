package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryTypeDTO implements Serializable {

    private int typeId;
    private String typeName;

}
