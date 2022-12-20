package org.tecky.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatchCouponDTO implements Serializable {

    private Integer couponId;

    private Integer uid;

    private Integer clientUid;

    private Integer orderId;

    private Integer subtotal;
}
