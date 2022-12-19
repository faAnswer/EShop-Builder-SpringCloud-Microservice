package org.tecky.warehouseservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_stock")
public class StockEntity {

    @Id
    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "stock_qty")
    private int stockQty;

    @Column(name = "warehouser_id")
    private int warehouserId;

}