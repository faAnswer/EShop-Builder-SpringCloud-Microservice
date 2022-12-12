package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_group_detail")
public class GroupDetailEntity implements Serializable {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer groupId;

    @Column(name = "colb_key")
    private String colbKey;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "cola_key")
    private String colaKey;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "client_id")
    private String clientId;

}