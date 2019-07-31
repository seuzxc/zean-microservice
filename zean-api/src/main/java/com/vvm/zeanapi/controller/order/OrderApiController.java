package com.vvm.zeanapi.controller.order;

import com.vvm.zeanapi.service.order.OrderApiService;
import com.vvm.zeanapi.service.order.response.UserOrderResp;
import com.vvm.zeanutil.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/zean-api/order")
public class OrderApiController {

    @Autowired
    private OrderApiService orderApiService;

    @GetMapping(value = "/user-orders/{clientType}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserOrderResp getUserOrders(@RequestParam("userId") String userId, @PathVariable("clientType") String clientType){
        //just a test for invoke other module
        log.info("current api call time: {}", DateUtil.currentDateStr(DateUtil.FMT_YYYY_MM_DD_HH_mm_ss));
        return orderApiService.getUserOrders(userId,clientType);
    }
}
