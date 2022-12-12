package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PostGroupDTO implements Serializable {

    @NotBlank
    private String clientId;

    @NotBlank
    private int typeId;

    @NotBlank
    private String groupName;

    private String groupDescription;

    private String picUrl;

    private String colaKey = "DEFAULT";

    private String colbKey;
}
