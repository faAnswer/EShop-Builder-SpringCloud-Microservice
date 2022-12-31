package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Integer productId;
    private Integer groupId;
    private String colaValue;
    private String colbValue;
}
