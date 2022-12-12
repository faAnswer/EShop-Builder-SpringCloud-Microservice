package org.tecky.productservice.entities.comprimarykey;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeListPK implements Serializable {


    private String clientId;
    private int typeId;
}
