package org.tecky.inventoryservice.entities.comprimarykey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Data
public class TypeEntityPK implements Serializable {

    private int typeId;
    private int categoryId;

}
