package com.policedog.craftadmin.commons;

import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ConstantUtils {
    public static final String SESSION_USER = "user";
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
