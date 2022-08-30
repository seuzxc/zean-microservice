package com.vvm.zeanuser.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/****
 * zengxiangcai
 * 2022/4/20 5:03 PM
 ***/

@Service
public class RedisService {

   @Autowired
   private RedissonClient redissonClient;

   @Autowired
   private JedisPool jedisPool;

   private int count;

   public void testLock(){
      RLock lock = redissonClient.getLock("lockKey");
      lock.lock();
      try(Jedis jedis = jedisPool.getResource()){
         System.err.println(count++);
         System.err.println(jedis.get("adminName"));
      }finally {
         lock.unlock();
      }
   }
}
