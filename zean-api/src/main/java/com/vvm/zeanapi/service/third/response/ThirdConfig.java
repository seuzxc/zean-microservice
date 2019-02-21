package com.vvm.zeanapi.service.third.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "third.baidu")
@Component
public class ThirdConfig {
    private String url;
    private String appId;
    private String appKey;
}
