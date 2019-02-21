package com.vvm.zeanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient(autoRegister = false)
public class ZeanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeanApiApplication.class, args);
    }

}

