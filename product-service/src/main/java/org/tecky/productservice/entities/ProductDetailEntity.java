package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_product_detail")
public class ProductDetailEntity implements Serializable {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "colb_value")
    private String colbValue;

    @Column(name = "cola_value")
    private String colaValue;

}