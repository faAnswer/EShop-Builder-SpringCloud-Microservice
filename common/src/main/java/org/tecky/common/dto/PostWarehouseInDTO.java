package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class PostWarehouseInDTO implements Serializable{

    private String refPic;

    private int inventoryId;

    private int qty;

    private String recordRef;

    private int handlerUid;

    private String additionMsg;

    private String shippmentId;

}
