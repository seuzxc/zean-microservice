package com.vvm.zeanuser;

import com.vvm.zeanuser.service.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZeanUserApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZeanUserApplication.class, args);
        RedisService service = context.getBean(RedisService.class);
        service.testLock();
    }

}

