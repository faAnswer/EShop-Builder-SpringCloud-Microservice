package org.tecky.productservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.tecky.productservice.entities.comprimarykey.TypeListPK;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_type_list")
@IdClass(TypeListPK.class)

public class TypeListEntity {

    @Id
    @Column(name = "client_id")
    private String clientId;

    @Id
    @JoinColumn(name = "type_id")
    private int typeId;
}
