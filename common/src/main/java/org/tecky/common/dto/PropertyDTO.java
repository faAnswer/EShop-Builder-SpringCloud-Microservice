package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PropertyDTO implements Serializable {

    private Integer groupId;
    private String colaValue;

}
