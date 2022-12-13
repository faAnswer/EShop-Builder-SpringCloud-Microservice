package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class PostProductDTO implements Serializable {

    @NotBlank
    private Integer groupId;

    @Min(0)
    private String clientId;

    private String colaValue = "默認";
    private String colbValue = "默認";
}
