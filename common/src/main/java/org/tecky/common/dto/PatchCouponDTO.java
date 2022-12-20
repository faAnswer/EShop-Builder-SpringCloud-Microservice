package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PatchCouponDTO implements Serializable {

    @NotNull
    private Integer couponId;

    @NotNull
    private Integer uid;

    @NotNull
    private Integer clientUid;

    @NotNull
    private Integer orderId;

    @NotNull
    private Integer subtotal;
}
