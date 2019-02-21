package com.vvm.zeanapi.service.third;

import com.vvm.zeanapi.service.third.response.ThirdConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ThirdConfigService {

    @Autowired
    private ThirdConfig thirdConfig;

    public ThirdConfig getConfig(){
        return thirdConfig;
    }
}
