package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "t_scope")
public class ScopeEntity implements Serializable {

    @Id
    @Column(name = "scope_id")
    private int scopeId;

    @Column(name = "scope_description")
    private String scopeDescription;

    @Column(name = "scope_name")
    private String scopeName;

}