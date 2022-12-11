package org.tecky.inventoryservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_product")
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "type_id")
    private int typeId;

}