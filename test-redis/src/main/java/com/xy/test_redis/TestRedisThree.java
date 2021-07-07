package com.xy.test_redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestRedisThree {
    public static void main(String[] args) {
        JedisPool pool=null;
        try {
            pool= TestRedisTwoPool.createJedisPool("192.168.220.128",6379);
            Jedis resource = pool.getResource();
            //开启事务
//            resource.multi();
            resource.set("test2","test2");
            System.out.println(resource.get("test2"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TestRedisTwoPool.closeRedisPool();
        }
    }
}
