package com.vvm.zeanapi.service.order;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.vvm.zeanapi.service.order.response.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RibbonOrderApiService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * invoke api with spring loadbalancer restTemplate,
     *  hystrix 和 restTemplate结合
     * @param userId
     * @return
     */
    @HystrixCommand(fallbackMethod = "getOrderInfoFallbackForRibbon",commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled" , value = "true"),//设置熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold" , value = "10"),//断路器的最小请求数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),//休眠时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage" , value = "60"),//断路频率

    })
    public List<OrderResp> getOrderInfoByRibbonRestTemplate(String userId) {

        OrderResp[] orderList = restTemplate.getForObject("http://zean-order/order/user-orders?userId=" + userId,
                OrderResp[].class);
        return Arrays.asList(orderList);
    }




    private List<OrderResp> getOrderInfoFallbackForRibbon(String userId, Throwable e){
        List<OrderResp> respList = new ArrayList<>();
        OrderResp resp = new OrderResp();
        resp.setCreateDate("2019-01-01");
        resp.setAmount(BigDecimal.ZERO);
        resp.setOrderNo("test-fallBack-ribbin");
        respList.add(resp);
        return respList;
    }
}
