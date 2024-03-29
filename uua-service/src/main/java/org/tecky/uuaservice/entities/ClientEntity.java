package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_client")
public class ClientEntity {

    @Id
    @Column(name = "client_uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientUid;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_id")
    private String clientId;

}