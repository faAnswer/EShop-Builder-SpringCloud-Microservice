package org.tecky.clientsideservice.entities.comprimarykey;

import lombok.Data;
import java.io.Serializable;

@Data
public class TypeEntityPK implements Serializable {

    private int typeId;
    private int categoryId;

}
