package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class AvailQtyRecordDTO implements Serializable {

    private Integer refId;

    private Integer inventoryId;

    private Integer availableDiff;

    private Integer orderId;
}
