package com.vvm.zeanrisk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class RuleTimer {
    @Autowired
    private RuleService ruleService;
    //每20秒运行一次

    public void run(){
       Timer t =  new Timer();
        System.err.println("timer run...");
       t.schedule(new TimerTask() {
           @Override
           public void run() {
                ruleService.executeRules();
           }
       }, 1000,60*1000);
    }

}
