package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class PostWarehouseDTO implements Serializable {

    @Pattern(regexp = "^\\w{5,10}$",
            message = "Warehouse Name must be 3 to 20 characters long")
    private String warehouseName;

    private Integer warehouseTel;

    @NotBlank
    private String warehouseAddress;

    @Min(0)
    private Integer clientUid;
}
