package com.policedog.craftadmin.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

    /**
     * 生成jedis连接池
     * @return
     */
    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(500);
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxWaitMillis(500 * 1000);

        JedisPool jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379,10*1000);
        return jedisPool;
    }

}
