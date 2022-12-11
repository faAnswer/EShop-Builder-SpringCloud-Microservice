package org.tecky.clientsideservice.entities.comprimarykey;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPK implements Serializable {

    private String clientId;
    private int typeId;
}
