package org.tecky.uuaservice.entities.compk;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Embeddable
public class RoleAuthEntityEmbeddable implements Serializable {

    @Column(name = "scope_id")
    private int scopeId;

    @Column(name = "role_id")
    private int roleId;

}