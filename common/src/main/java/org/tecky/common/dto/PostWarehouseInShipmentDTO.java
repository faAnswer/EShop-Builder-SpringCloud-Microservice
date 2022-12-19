package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostWarehouseInShipmentDTO implements Serializable {

    private String shippmentCompany;

    private Integer warehouserId;

    private String shippmentNum;

    private String progressStatus = "已簽收";

    private final String directionType = "in";






}
