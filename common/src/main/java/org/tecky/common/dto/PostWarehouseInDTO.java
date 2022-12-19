package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;
@Data
public class PostWarehouseInDTO implements Serializable{

    private String refPic;

    @Min(1)
    private Integer inventoryId;

    @Min(1)
    private Integer qty;

    private String recordRef;

    @Min(1)
    private Integer handlerUid;

    private String additionMsg;

    private Integer shippmentId;

}
