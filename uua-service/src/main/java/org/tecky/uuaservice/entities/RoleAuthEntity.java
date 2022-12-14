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
    @Column(name = "client_uid")
    private int clientUid;

    @Id
    @JoinColumn(name = "role_id")
    private int roleId;

    @Column(name = "scope_id")
    private int scopeId;

}