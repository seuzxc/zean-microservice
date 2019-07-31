package com.vvm.zeanapi.service.order;

import com.vvm.zeanapi.client.OrderFeignClient;
import com.vvm.zeanapi.constant.ServiceIdConstants;
import com.vvm.zeanapi.service.order.response.OrderResp;
import com.vvm.zeanapi.service.order.response.UserOrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderApiService {

    @Autowired
    private RibbonOrderApiService ribbonOrderApiService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrderFeignClient orderFeignClient;


    /***
     * 接口没有实际意义，仅仅为为了测试不同的服务调用方式(clientType)
     * 1、通过feign调用
     * 2、通过标准的restTemplate调用
     * 3、通过discoveryClient调用
     * @param userId
     * @param clientType
     * @return
     */
    public UserOrderResp getUserOrders(String userId, String clientType) {
        UserOrderResp resp = new UserOrderResp();
        resp.setUserId(userId);
        resp.setUserName("username");

        if ("feign".equalsIgnoreCase(clientType)) {
            resp.setOrders(getOrderInfoByFeign(userId));
        } else if ("ribbon".equalsIgnoreCase(clientType)) {
            resp.setOrders(ribbonOrderApiService.getOrderInfoByRibbonRestTemplate(userId));
        } else {
            resp.setOrders(getOrderInfoByDiscoveryClient(userId));
        }
        return resp;
    }



    /**
     * invoke api with feign
     * @param userId
     * @return
     */
    public List<OrderResp> getOrderInfoByFeign(String userId) {
        return orderFeignClient.getUserOrders(userId);
    }

    /**
     * invoke api with discoveryClient，without loadBalance
     * @param userId
     * @return
     */
    private List<OrderResp> getOrderInfoByDiscoveryClient(String userId) {
        RestTemplate restTemplate1 = new RestTemplate();

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(ServiceIdConstants.ZEAN_ORDER);
        if (CollectionUtils.isEmpty(serviceInstances)) {
            return null;
        }
        String hostUri = serviceInstances.get(0).getUri().toString();
        String serviceUri = String.format("%s/order/user-orders?userId=" + userId, hostUri);
        OrderResp[] orderList = restTemplate1.getForObject(serviceUri,
                OrderResp[].class);
        return Arrays.asList(orderList);
    }

}
