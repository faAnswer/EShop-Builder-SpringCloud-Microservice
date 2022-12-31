package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InventorySumDTO implements Serializable {

    private Integer productId;
    private Integer onhandQty = 0;
    private Integer availableQty = 0;
    private Integer accountingQty = 0;
    private List<InventoryDTO> inventories;

}
