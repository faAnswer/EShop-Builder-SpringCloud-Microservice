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
@Table(name = "t_group_detail")
public class GroupDetailEntity {

    @Id
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "colb_key")
    private String colbKey;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "cola_key")
    private String colaKey;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "client_id")
    private String clientId;

}