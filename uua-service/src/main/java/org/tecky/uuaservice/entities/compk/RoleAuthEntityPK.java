package org.tecky.uuaservice.entities.compk;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleAuthEntityPK implements Serializable {

    private int roleId;
    private int scopeId;
}
