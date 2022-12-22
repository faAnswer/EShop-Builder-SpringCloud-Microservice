package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PostOrderDTO implements Serializable {

    private Integer uid;

    private Integer clientUid;

    private List<PostOrderProductDTO> postOrderProductDTOList;

}
