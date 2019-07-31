package com.vvm.zeanrules.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class KieKnowledgeHelper {
    public static KieContainer createRuleBase(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.newKieClasspathContainer();
        return kieContainer;
    }

    public static StatelessKieSession getStatelessKieSession(KieContainer kieContainer, String sessionName){
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession(sessionName);
        return kieSession;
    }
}
