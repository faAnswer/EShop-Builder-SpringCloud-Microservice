package org.tecky.uuaservice.entities.compk;

import lombok.Data;
import org.tecky.uuaservice.entities.ScopeEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Data
@Embeddable
public class TestPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "scopeId")
    private ScopeEntity scopeEntity;

    @Column(name = "role_id")
    private int roleId;

}