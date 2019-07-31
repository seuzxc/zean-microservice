package com.vvm.rules;

import com.vvm.zeanrules.model.RUserInfo;
import com.vvm.zeanrules.util.KieKnowledgeHelper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;


public class RuleTest {
    StatelessKieSession statelessKieSession = null;
    static KieContainer kieContainer;

    @BeforeClass
    public static void beforeClass(){
        kieContainer = KieKnowledgeHelper.createRuleBase();
    }

    @Test
    public void testRule(){
        statelessKieSession = KieKnowledgeHelper.getStatelessKieSession(kieContainer,"TEST");
        RUserInfo user = new RUserInfo();
        user.setAge(89);
        statelessKieSession.execute(user);
    }
    @Test
    public void testStart(){
        System.err.println("test..");
    }
}
