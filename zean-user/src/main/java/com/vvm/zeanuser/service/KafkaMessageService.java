package com.vvm.zeanuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/****
 * zengxiangcai
 * 2022/4/22 11:28 AM
 ***/

@Service
public class KafkaMessageService {

  @Autowired
  private KafkaTemplate<String,String> template;

  public void sendMsg(){
    template.send("default","zxc").addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onFailure(Throwable throwable) {

      }

      @Override
      public void onSuccess(SendResult<String, String> stringStringSendResult) {

      }
    });
  }
}
