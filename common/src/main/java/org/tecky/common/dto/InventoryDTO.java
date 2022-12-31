package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryDTO implements Serializable {

    private Integer inventoryId;
    private Integer onhandQty;
    private Integer availableQty;
    private Integer accountingQty;
}
