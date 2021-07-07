package com.xy.test_redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedisTwoPool {

    //定义连接池
    private static JedisPool pool = null;

    public static void closeRedisPool() {
        if (pool == null) {
            pool.close();
        }
    }

    public static JedisPool createJedisPool(String host, int port) {
        if (pool == null) {
            //创建连接池配置对象
            JedisPoolConfig config = new JedisPoolConfig();
            //设置最大实例数
            config.setMaxTotal(10);
            //设置最大空闲连接数
            config.setMaxIdle(3);
            //提前检查连接可用
            config.setTestOnBorrow(true);
            //创建连接
            pool = new JedisPool(host, port);
        }
        return pool;
    }


}
