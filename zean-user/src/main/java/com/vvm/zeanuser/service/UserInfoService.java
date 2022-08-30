package com.vvm.zeanuser.service;

import com.vvm.zeanuser.service.response.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Service
public class UserInfoService {

    @Transactional
    public UserInfo getUserInfoById(String userId){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setAge(30);
        userInfo.setUserName("张三");
        userInfo.setMobile("13810010001");
        return userInfo;
    }

    public static void main(String[] args) throws Exception {
        Map<String,String> m = new HashMap<>();
        m.put(null,"1");
        System.err.println(m.get(null));

        int n = 16 - 1;
        n |= n >>> 1;
        System.err.println(n);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.err.println(n);

        CustomThread t = new CustomThread();
//        t.start();
        t.join(1);
        System.err.println(t.getState());
        t.wait();

    }

    public  static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "data";
        }
    }

    public static class CustomThread extends Thread {

        @Override
        public void run() {
            System.err.println("run");
        }
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {

        }
    }
}
