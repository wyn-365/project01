package com.jedis.test;

import com.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 连接池的工具类的使用
 *
 */
public class Test01 {

    @Test
    public void test01(){

        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello","王一宁");


        jedis.close();
    }

}
