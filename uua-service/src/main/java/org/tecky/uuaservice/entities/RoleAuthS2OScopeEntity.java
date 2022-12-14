package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_role_auth")
@IdClass(value = org.tecky.uuaservice.entities.compk.RoleAuthEntityPK.class)
public class RoleAuthS2OScopeEntity extends RoleAuthEntity{


    @OneToOne
    private ScopeEntity scopeEntity;
}
