package com.xy.test_redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestRedisOne_Jedis {
    public static void main(String[] args) {
        //利用jedis操作redis
        //创建对象指定端口号和IP地址
        Jedis jedis=new Jedis("192.168.220.128",6379);
        jedis.set("test1","test1");
        System.out.println(jedis.get("test1"));
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
