package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class PostOrderDTO implements Serializable {

    @NotNull
    private Integer uid;

    @NotNull
    private Integer clientUid;

    @NotNull
    private Integer couponId;

    @NotNull
    private List<PostOrderProductDTO> postOrderProductDTOList;

}
