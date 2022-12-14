package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "t_client")
@SecondaryTable(name = "t_user")
public class ClientSecUserS2MRoleAuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_uid", table = "t_client")
    private int clientUid;

    @Column(name = "client_name", table = "t_client")
    private String clientName;

    @Column(name = "client_id", table = "t_client")
    private String clientId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", table = "t_user")
    private int uid;

    @Column(name = "role_id", table = "t_user")
    private int roleId;

    @Column(name = "shapassword" , table = "t_user")
    private String shapassword;

    @Column(name = "email", table = "t_user")
    private String email;

    @Column(name = "username", table = "t_user")
    private String username;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "client_uid",
            referencedColumnName = "client_uid"),
            @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    })
    private List<RoleAuthEntity> roleAuthEntityList;

}
