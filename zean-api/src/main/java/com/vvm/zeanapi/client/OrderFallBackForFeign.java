package com.vvm.zeanapi.client;

import com.vvm.zeanapi.service.order.response.OrderResp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderFallBackForFeign implements OrderFeignClient {
    @Override
    public List<OrderResp> getUserOrders(String userId) {
        List<OrderResp> respList = new ArrayList<>();
        OrderResp resp = new OrderResp();
        resp.setCreateDate("2019-01-01");
        resp.setAmount(BigDecimal.ZERO);
        resp.setOrderNo("test-fallBack-feign");
        respList.add(resp);
        return respList;
    }
}
