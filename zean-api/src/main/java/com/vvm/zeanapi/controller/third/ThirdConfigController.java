package com.vvm.zeanapi.controller.third;

import com.vvm.zeanapi.service.third.ThirdConfigService;
import com.vvm.zeanapi.service.third.response.ThirdConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/third")
public class ThirdConfigController {

    @Autowired
    private ThirdConfigService thirdConfigService;

    @GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ThirdConfig getConfig() {
        return thirdConfigService.getConfig();
    }
}
