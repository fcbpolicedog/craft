package com.policedog.craftadmin.commons;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisService {

    public <T> T get(String key,Class<T> clazz) {
        Jedis jedis = new Jedis("localhost");

        String string = jedis.get(key);
        T t = stringToBean(string,clazz);//把字符串转换为bean
        jedis.close();
        return t;

    }

    public <T> Boolean set(String key,T value) {
        Jedis jedis = new Jedis("localhost");
        String string = beanToString(value);
        if (string == null||string.length()<=0) {
            return false;
        }
        jedis.set(key, string);
        jedis.close();
        return true;
    }

    //把一个对象转换为字符串
    private <T>String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz==Integer.class) {
            return ""+value;
        }else if (clazz == String.class) {
            return (String)value;
        }else if (clazz == long.class ||clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }

    }

    //把字符串转换成对象
    private <T> T stringToBean(String string,Class<T> clazz) {
        if (string == null||string.length() <= 0) {
            return null;
        }
        if (clazz == int.class || clazz==Integer .class) {
            return (T)Integer.valueOf(string);
        }else if (clazz == String.class) {
            return (T)string;
        }else if (clazz ==  long.class ||clazz == Long.class) {
            return (T)Long.valueOf(string);
        }else {
            return JSON.toJavaObject(JSON.parseObject(string), clazz);
        }
    }

}
