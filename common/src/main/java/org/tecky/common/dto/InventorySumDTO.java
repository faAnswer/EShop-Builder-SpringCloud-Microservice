package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventorySumDTO implements Serializable {

    private Integer productId;
    private Integer onhandQty = 0;
    private Integer availableQty = 0;
    private Integer accountingQty = 0;
}
