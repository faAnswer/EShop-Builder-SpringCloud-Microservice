package org.tecky.orderservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_order_detail")
public class OrderDetailEntity {

    @Id
    @Column(name = "detail_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    @Column(name = "amount")
    private String amount;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "order_id")
    private Integer orderId;

}