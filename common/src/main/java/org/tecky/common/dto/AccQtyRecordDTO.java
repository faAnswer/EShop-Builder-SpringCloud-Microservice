package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccQtyRecordDTO implements Serializable {

    private Integer refId;

    private Integer inventoryId;

    private Integer paymentId;

    private Integer accountingDiff;

    private Integer orderId;
}
