package com.vvm.zeanorder.controller;

import com.vvm.zeanorder.service.OrderInfoService;
import com.vvm.zeanorder.service.response.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/user-orders")
    public List<OrderInfo> getOrderListByUserId(@RequestParam("userId") String userId){
        return orderInfoService.getOrderListByUserId(userId);
    }
}
