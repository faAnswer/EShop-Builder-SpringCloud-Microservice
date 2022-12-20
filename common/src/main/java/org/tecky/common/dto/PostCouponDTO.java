package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class PostCouponDTO implements Serializable {

    @Pattern(regexp = "^.{3,16}$",
            message = "Coupon Name must be 3 to 16 characters long")
    private String couponName;

    @Min(0)
    private Integer uid;

    @Min(1)
    private Integer clientUid;
    private String expiryDate = "2100-01-01";

    private Integer availableQty = 99999;

    private String couponDescription;

    private Integer typeId;

    private Integer var3;

    private Integer var2;

    private Integer var1;

    public void setExpiryDate(String expiryDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        sdf.parse(expiryDate);

        this.expiryDate = expiryDate;
    }
}
