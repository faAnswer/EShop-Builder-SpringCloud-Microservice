package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OnHandQtyRecordDTO implements Serializable {

    private Integer refId;

    private Integer onhandDiff;

    private Integer inventoryId;

    private Integer shipmentId;

}
