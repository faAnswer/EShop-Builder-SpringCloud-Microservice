package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_product_detail")
public class ProductDetailEntity implements Serializable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "colb_value")
    private String colbValue;

    @Column(name = "cola_value")
    private String colaValue;

    @Column(name = "group_id")
    private Integer groupId;

}