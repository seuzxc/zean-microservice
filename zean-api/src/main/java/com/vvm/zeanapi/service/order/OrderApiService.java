package com.vvm.zeanapi.service.order;

import com.vvm.zeanapi.client.OrderFeignClient;
import com.vvm.zeanapi.constant.ServiceIdConstants;
import com.vvm.zeanapi.service.order.response.OrderResp;
import com.vvm.zeanapi.service.order.response.UserOrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderApiService {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderFeignClient orderFeignClient;


    public UserOrderResp getUserOrders(String userId, String clientType) {
        UserOrderResp resp = new UserOrderResp();
        resp.setUserId(userId);
        resp.setUserName("username");

        if ("feign".equalsIgnoreCase(clientType)) {
            resp.setOrders(getOrderInfoByFeign(userId));
        } else if ("standard".equalsIgnoreCase(clientType)) {
            resp.setOrders(getOrderInfoByStandardRestTemplate(userId));
        } else {
            resp.setOrders(getOrderInfoByRibbinRestTemplate(userId));
        }
        return resp;
    }

    /**
     * invoke api with standard restTemplate，without loadbalance
     * @param userId
     * @return
     */
    private List<OrderResp> getOrderInfoByStandardRestTemplate(String userId) {
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

    /**
     * invoke api with spring loadbalancer restTemplate
     * @param userId
     * @return
     */
    private List<OrderResp> getOrderInfoByRibbinRestTemplate(String userId) {

        OrderResp[] orderList = restTemplate.getForObject("http://zean-order/order/user-orders?userId=" + userId,
                OrderResp[].class);
        return Arrays.asList(orderList);
    }

    private List<OrderResp> getOrderInfoByFeign(String userId) {

        return orderFeignClient.getUserOrders(userId);
    }


}
