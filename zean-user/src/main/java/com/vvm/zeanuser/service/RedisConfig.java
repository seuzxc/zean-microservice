package com.vvm.zeanuser.service;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/****
 * zengxiangcai
 * 2022/4/20 5:07 PM
 ***/

@Configuration
public class RedisConfig {

  @Bean
  public RedissonClient getRedisClient(){
    Config config = new Config();
    config.useSingleServer()
            // use "rediss://" for SSL connection
            .setAddress("redis://127.0.0.1:6379");
    RedissonClient redisson = Redisson.create(config);
    return redisson;
  }

  @Bean(name="jedisPool")
  public JedisPool getJedisPool(){
     JedisPool pool =new JedisPool("127.0.0.1", 6379);
     return pool;
  }

}
