package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class PostRoleDTO implements Serializable {

    @Pattern(regexp = "^[A-Z]{3,20}$",
             message = "Role Name must be 3 to 20 characters long upper case letters")
    private String roleName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,10}$",
            message = "Client Id must be 5 to 10 characters long")
    private String clientId;

    @Size(min = 1)
    private List<Integer> scopeIdList;

}
