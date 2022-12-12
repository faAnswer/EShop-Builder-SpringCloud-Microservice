package org.tecky.productservice.entities.comprimarykey;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupEntityPK implements Serializable {

    private int groupId;
    private int productId;

}
