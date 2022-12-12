package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PostGroupDTO implements Serializable {

    @NotBlank
    private String clientId;

    @Min(0)
    private Integer typeId;

    @NotBlank
    private String groupName;

    private String groupDescription;

    private String picUrl;

    private String colaKey = "選項 1";

    private String colbKey = "選項 2";
}
