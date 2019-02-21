package com.vvm.zeanapi.service.order.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderResp {
    private String userName;
    private String userId;
    private List<OrderResp> orders;
}
