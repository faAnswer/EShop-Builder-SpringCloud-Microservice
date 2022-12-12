package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_group")
@IdClass(org.tecky.productservice.entities.comprimarykey.GroupEntityPK.class)

public class GroupEntity implements Serializable {

    @Id
    @Column(name = "group_id")
    private int groupId;

    @JoinColumn(name = "product_id")
    private int productId;

}