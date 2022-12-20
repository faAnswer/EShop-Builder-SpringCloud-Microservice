package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class PostClientRegDTO implements Serializable {

    @Pattern(regexp = "^[\\w\\s]{5,20}$",
            message = "Client Name must be 5 to 20 characters long")
    private String clientName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,10}$",
             message = "Client Id must be 5 to 10 characters long")
    private String clientId;

    @Pattern(regexp = "^(?=.*[a-zA-Z]+)(?=.*[0-9]+)\\w{7,16}$",
             message = "Password must be 7 to 16 characters long and include at least one number and one letter")
    private String password;

    @Pattern(regexp = "^\\w+@\\w+\\.[a-zA-Z0-9]+$",
             message = "Must be a valid email address")
    private String email;

    @Pattern(regexp = "^\\w{7,16}$",
             message = "Username must be 7 to 16 characters long")
    private String username;
}
