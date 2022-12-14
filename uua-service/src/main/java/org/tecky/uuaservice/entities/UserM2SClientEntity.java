package org.tecky.uuaservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_user")
public class UserM2SClientEntity extends UserEntity{

//    @ManyToOne
//    @JoinColumn(name = "client_uid")
//    private ClientEntity clientEntity;

}
