package com.vvm.zeanorder.service.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrderInfo {
    private String orderNo;
    private Date createTime;
    private BigDecimal amount;
    private String status;
}
