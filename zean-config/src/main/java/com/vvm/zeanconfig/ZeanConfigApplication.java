package com.vvm.zeanconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ZeanConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeanConfigApplication.class, args);
    }

}

