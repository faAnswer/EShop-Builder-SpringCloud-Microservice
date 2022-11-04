package org.tecky.uaaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_user_role")
public class UserRoleEntity {

    @Id
    private int uid;

    @Column(name = "role_id", nullable = false)
    private int roleid;


}
