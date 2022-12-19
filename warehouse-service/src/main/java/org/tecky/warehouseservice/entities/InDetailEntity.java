package org.tecky.warehouseservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_in_detail")
public class InDetailEntity {

    @Id
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "ref_pic")
    private String refPic;

    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "qty")
    private int qty;

    @Column(name = "record_ref")
    private String recordRef;

    @Column(name = "handler_uid")
    private int handlerUid;

    @Column(name = "addition_msg")
    private String additionMsg;

}