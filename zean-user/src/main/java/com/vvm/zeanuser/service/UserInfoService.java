package com.vvm.zeanuser.service;

import com.vvm.zeanuser.service.response.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    public UserInfo getUserInfoById(String userId){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setAge(30);
        userInfo.setUserName("张三");
        userInfo.setMobile("13810010001");
        return userInfo;
    }
}
