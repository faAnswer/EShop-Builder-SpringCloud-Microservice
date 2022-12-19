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
@Table(name = "t_out_detail")
public class OutDetailEntity {

    @Id
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "ref_pic")
    private String refPic;

    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "qty")
    private int qty;

    @Column(name = "handler_uid")
    private int handlerUid;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "addition_msg")
    private String additionMsg;

}