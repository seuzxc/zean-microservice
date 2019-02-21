package com.vvm.zeanuser.controller;

import com.vvm.zeanuser.service.UserInfoService;
import com.vvm.zeanuser.service.response.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/user-info")
    public UserInfo getUserInfoById(String userId) {
        return userInfoService.getUserInfoById(userId);
    }
}
