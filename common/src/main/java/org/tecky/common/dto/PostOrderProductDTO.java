package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostOrderProductDTO implements Serializable {

    private Integer productId;

    private Integer qty;
}
