package org.tecky.clientsideservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_type")
@IdClass(org.tecky.clientsideservice.entities.comprimarykey.TypeEntityPK.class)
public class TypeEntity {

    @Id
    @Column(name = "type_id")
    private int typeId;

    @Id
    @JoinColumn(name = "category_id")
    private int categoryId;

}