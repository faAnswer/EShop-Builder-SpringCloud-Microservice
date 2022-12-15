package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_role_auth")
public class RoleAuthS2OScopeEntity{

    @Column(name = "role_id", table = "t_role_auth")
    private int roleId;

    @Id
    @Column(name = "scope_id")
    private int scopeId;

    @OneToOne
    @JoinColumn(name = "scope_id")
    private ScopeEntity scopeEntity;

//    Work
}
