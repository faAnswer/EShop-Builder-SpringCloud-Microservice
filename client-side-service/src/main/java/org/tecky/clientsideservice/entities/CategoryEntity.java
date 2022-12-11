package org.tecky.clientsideservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_category")
@IdClass(org.tecky.clientsideservice.entities.comprimarykey.CategoryPK.class)

public class CategoryEntity {

    @Id
    @Column(name = "client_id")
    private int clientId;

    @Id
    @Column(name = "type_id")
    private int typeId;
}
