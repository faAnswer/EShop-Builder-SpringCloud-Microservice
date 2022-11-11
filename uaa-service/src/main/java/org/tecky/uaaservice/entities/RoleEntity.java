package org.tecky.uaaservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_role")
public class RoleEntity {

    @Id
    private int roleid;

    @Column(name = "name")
    private String name;

}