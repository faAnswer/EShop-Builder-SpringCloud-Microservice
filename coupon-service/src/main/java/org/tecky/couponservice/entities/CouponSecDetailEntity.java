package org.tecky.couponservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_coupon")
@SecondaryTable(name = "t_coupon_detail")
public class CouponSecDetailEntity implements Serializable {

    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponId;

    @Column(name = "uid", table = "t_coupon")
    private Integer uid;

    @Column(name = "client_uid", table = "t_coupon")
    private Integer clientUid;

    @Column(name = "expiry_date", table = "t_coupon")
    private String expiryDate;

    @Column(name = "available_qty", table = "t_coupon")
    private Integer availableQty;

    @Column(name = "coupon_description", table = "t_coupon_detail")
    private String couponDescription;

    @Column(name = "type_id", table = "t_coupon_detail")
    private Integer typeId;

    @Column(name = "var3", table = "t_coupon_detail")
    private Integer var3;

    @Column(name = "var2", table = "t_coupon_detail")
    private Integer var2;

    @Column(name = "var1", table = "t_coupon_detail")
    private Integer var1;

    @Column(name = "coupon_name", table = "t_coupon_detail")
    private String couponName;
}