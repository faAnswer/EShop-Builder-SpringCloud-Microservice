package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_role_auth")
@IdClass(value = org.tecky.uuaservice.entities.compk.RoleAuthEntityPK.class)
public class RoleAuthEntity {

    @Id
    @Column(name = "role_id")
    private int roleId;

    @Id
    @JoinColumn(name = "scope_id")
    private int scopeId;
}