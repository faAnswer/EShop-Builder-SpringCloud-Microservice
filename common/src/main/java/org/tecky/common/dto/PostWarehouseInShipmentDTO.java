package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Data
public class PostWarehouseInShipmentDTO implements Serializable {

    private String shippmentCompany;

    @Min(1)
    private Integer warehouserId;

    private String shippmentNum;

    private String progressStatus = "已簽收";

    private final String directionType = "in";

    private List<PostWarehouseInDTO> postWarehouseInDTOList;

}
