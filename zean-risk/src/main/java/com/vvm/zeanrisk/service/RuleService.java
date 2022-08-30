package com.vvm.zeanrisk.service;


import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.event.kiescanner.KieScannerEventListener;
import org.kie.api.event.kiescanner.KieScannerStatusChangeEvent;
import org.kie.api.event.kiescanner.KieScannerUpdateResultsEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;
import com.vvm.zeanrules.model.RUserInfo;

import java.util.Date;

import javax.annotation.PostConstruct;

@Service
public class RuleService {

    private KieContainer kieContainer;

    @PostConstruct
    public void init() {
        KieServices ks = KieServices.Factory.get();


        // kieContainer = ks.newKieClasspathContainer();
        //ks.newKieContainer(ks.newReleaseId("com.vvm","zean-rules","release"));
        kieContainer = ks.newKieContainer(ks.newReleaseId("com.vvm", "zean-rules", "1.0.0"));
        System.err.println("ksContainer: " + kieContainer == null);
        KieScanner kieScanner = ks.newKieScanner(kieContainer, "C:/kjars");
        kieScanner.addListener(new KieScannerEventListener() {
            @Override
            public void onKieScannerStatusChangeEvent(KieScannerStatusChangeEvent kieScannerStatusChangeEvent) {
                System.err.println("status change");
                System.err.println(kieScannerStatusChangeEvent.getStatus());

            }

            @Override
            public void onKieScannerUpdateResultsEvent(KieScannerUpdateResultsEvent kieScannerUpdateResultsEvent) {
                System.err.println("update result: "+kieScannerUpdateResultsEvent.getResults().toString());
            }
        });

        kieScanner.start(1000 * 10);//10 seconds to runikm
    }

    public void executeRules() {
        StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("TEST");
        RUserInfo rUserInfo = new RUserInfo();
        rUserInfo.setAge(89);
        System.err.println("start to execute rules, date: " + new Date());
        statelessKieSession.execute(rUserInfo);
        System.err.println();
    }
}
