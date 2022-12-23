package org.tecky.couponservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Table(name = "t_coupon_record")
public class CouponRecordEntity implements Serializable {

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "use_datetime")
    private String useDatetime;

    @Column(name = "discount")
    private Integer discount;

}