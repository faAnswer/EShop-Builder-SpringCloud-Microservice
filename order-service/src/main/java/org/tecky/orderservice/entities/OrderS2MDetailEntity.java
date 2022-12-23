package org.tecky.orderservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_order")
public class OrderS2MDetailEntity {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "shipping_amount")
    private String shippingAmount;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "subtotal")
    private String subtotal;

    @Column(name = "discount_amount")
    private String discountAmount;

    @Column(name = "client_uid")
    private Integer clientUid;

    @OneToMany(mappedBy="orderS2MDetailEntity", cascade = CascadeType.ALL)
    private List<DetailM2SOrderEntity> detailM2SOrderEntityList;

}