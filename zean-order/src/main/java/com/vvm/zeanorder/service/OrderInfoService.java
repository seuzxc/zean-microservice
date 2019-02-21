package com.vvm.zeanorder.service;

import com.vvm.zeanorder.service.response.OrderInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoService {

    public List<OrderInfo> getOrderListByUserId(String userId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo("201902120001");
        orderInfo.setCreateTime(new Date());
        orderInfo.setStatus("1");
        orderInfo.setAmount(new BigDecimal("100.12"));
        return Arrays.asList(orderInfo);
    }
}
