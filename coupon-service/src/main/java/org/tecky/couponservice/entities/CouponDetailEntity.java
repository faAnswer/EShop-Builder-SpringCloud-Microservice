package org.tecky.couponservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_coupon_detail")
public class CouponDetailEntity implements Serializable {

    @Id
    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "coupon_description")
    private String couponDescription;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "var3")
    private Integer var3;

    @Column(name = "var2")
    private Integer var2;

    @Column(name = "var1")
    private Integer var1;

    @Column(name = "coupon_name")
    private String couponName;

}