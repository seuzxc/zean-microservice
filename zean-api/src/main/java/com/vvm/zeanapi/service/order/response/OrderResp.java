package com.vvm.zeanapi.service.order.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResp {
    private String orderNo;
    private String createDate;
    private BigDecimal amount;
}
