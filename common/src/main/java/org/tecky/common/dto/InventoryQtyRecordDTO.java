package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class InventoryQtyRecordDTO implements Serializable {

    private Integer inventoryId;
    private List<OnHandQtyRecordDTO> onHandQtyRecordDTOList;
    private List<AccQtyRecordDTO> accQtyRecordDTOList;
    private List<AvailQtyRecordDTO> availQtyRecordDTOList;


}
