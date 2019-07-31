package com.vvm.zeanapi.client;

import com.vvm.zeanapi.service.order.response.OrderResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="zean-order",fallback = OrderFallBackForFeign.class )
public interface OrderFeignClient {
    @RequestMapping(value="/order/user-orders", method = RequestMethod.GET)
    List<OrderResp> getUserOrders(@RequestParam("userId") String userId);
}
