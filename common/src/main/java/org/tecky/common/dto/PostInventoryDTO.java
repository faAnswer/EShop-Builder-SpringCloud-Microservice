package org.tecky.common.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class PostInventoryDTO implements Serializable {

    @Min(0)
    private Integer productId;

    @NotBlank
    private String batchNo;

    private String expiryDate = "2100-01-01";

    private String additionMsg;

    private String supplier;

    private String supplierContact;

    public void setExpiryDate(String expiryDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        sdf.parse(expiryDate);

        this.expiryDate = expiryDate;
    }
}
