package com.moon.redis;
/**
 * Created by lesline on 15/11/27.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class JredisTest {



    @Test
    public void putAndGet() {
//        JRedis jredis = new JRedisClient("192.168.1.238", 6380);
//        if(jredis.exists("name")){
//            jredis.get("name");
//        }
//        redis.quit();



    }


}
