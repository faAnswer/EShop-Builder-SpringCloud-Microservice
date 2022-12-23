package org.tecky.orderservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_order_detail")
public class DetailM2SOrderEntity {

    @Id
    @Column(name = "detail_Id")
    private Integer detailId;

    @Column(name = "amount")
    private String amount;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderS2MDetailEntity orderS2MDetailEntity;

}