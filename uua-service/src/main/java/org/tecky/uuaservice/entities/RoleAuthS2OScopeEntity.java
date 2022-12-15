package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.tecky.uuaservice.entities.compk.TestPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_role_auth")
public class RoleAuthS2OScopeEntity{

    @Id
    @Column(name = "role_id")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "scopeId")
    private ScopeEntity scopeEntity;
}
