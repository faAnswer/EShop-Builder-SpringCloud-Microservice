package org.tecky.uuaservice.entities.compk;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class RoleAuthEntityPK implements Serializable {

    private int clientUid;
    private int roleId;
}
