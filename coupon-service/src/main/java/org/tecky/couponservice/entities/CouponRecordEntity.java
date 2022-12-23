package org.tecky.couponservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.faAnswer.util.DateUtil;
import org.faAnswer.util.MySQLDateUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;


@Entity
@Getter
@Setter
@Table(name = "t_coupon_record")
public class CouponRecordEntity implements Serializable {

    public CouponRecordEntity() throws ParseException {

        useDatetime = MySQLDateUtil.toDate(DateUtil.toDate());
    }

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "use_datetime")
    private String useDatetime;

    @Column(name = "discount")
    private Integer discount;

}