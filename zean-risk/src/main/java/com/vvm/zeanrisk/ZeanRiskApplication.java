package com.vvm.zeanrisk;

import com.vvm.zeanrisk.service.RuleTimer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZeanRiskApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ZeanRiskApplication.class, args);
        RuleTimer timer  = ctx.getBean(RuleTimer.class);
        timer.run();
    }

}
