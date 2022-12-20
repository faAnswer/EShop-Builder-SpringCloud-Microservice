package org.tecky.couponservice.entities;

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
@Table(name = "t_coupon_type")
public class CouponTypeEntity implements Serializable {

    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "condition1_description")
    private String condition1Description;

    @Column(name = "condition2_description")
    private String condition2Description;

    @Column(name = "type_description")
    private String typeDescription;

    @Column(name = "var1_type")
    private String var1Type;

    @Column(name = "var2_type")
    private String var2Type;

    @Column(name = "var3_type")
    private String var3Type;

}