package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name = "t_layout")
public class LayoutEntity {

    @Id
    private int id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "global_id")
    private int globalId;

    @Column(name = "footer_id")
    private int footerId;
}
