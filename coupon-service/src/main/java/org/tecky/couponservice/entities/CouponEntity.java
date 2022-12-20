package org.tecky.couponservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_coupon")
public class CouponEntity implements Serializable {

    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "client_uid")
    private Integer clientUid;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "available_qty")
    private Integer availableQty;

}