package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "client_uid")
    private int clientUid;

    @Column(name = "shapassword")
    private String shapassword;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

}