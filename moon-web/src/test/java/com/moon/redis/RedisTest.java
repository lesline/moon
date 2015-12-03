package com.moon.redis;
/**
 * Created by lesline on 15/11/27.
 */

import com.moon.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class RedisTest {

    @Autowired
    RedisTemplate jedisTemplate;

    /**
     * spring把专门的数据操作独立封装在spring-data系列中，spring-data-redis自然是针对Redis的独立封装了。
     * 当前版本1.0.1，主要是将jedis、jredis、rjc以及srp等Redis Client进行了封装，同时支持事务。
     * 目前redis的java客户端有两种,jdbc-redis和jredis,从redis官方wiki上以及多种资料上的综合评价，
     * jdbc-redis性能较差，目前主流的Java客户端还是jredis。
     */
    @Test
    public void putAndGet() {
        jedisTemplate.opsForHash().put("user", "name", "张三");
        Object name = jedisTemplate.opsForHash().get("user", "name");
        System.out.println(name);
    }

    @Test
    public void putAndGetObject() {
        Customer customer = new Customer();
        customer.setName("lesline");
        jedisTemplate.opsForList().leftPush("customer", customer);
        System.out.println("---------");
        Object object = jedisTemplate.opsForList().rightPop("customer");

        System.out.println(object);

    }


}
