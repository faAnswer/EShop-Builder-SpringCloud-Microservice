package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PostOrderProductDTO implements Serializable {

    @NotNull
    private Integer productId;

    @NotNull
    private Integer qty;
}
