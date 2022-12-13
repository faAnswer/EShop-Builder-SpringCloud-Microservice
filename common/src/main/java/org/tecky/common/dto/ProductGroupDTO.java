package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ProductGroupDTO implements Serializable {

    @NotBlank
    private Integer groupId;

    private Integer typeId;

    private String clientId;

    private String groupName;

    private String groupDescription;

    private String picUrl;

    private String colaKey;

    private String colbKey;

    private Integer isvalid;

}
