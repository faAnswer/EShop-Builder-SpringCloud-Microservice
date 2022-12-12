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
@Table(name = "t_type_detail")
public class TypeDetailEntity {

    @Id
    @Column(name = "type_id")
    private int typeId;

    @Column(name = "type_name")
    private String typeName;

}