package com.moon.redis;

import com.moon.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * Created by lesline on 15/11/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class JedisTest {

    @Test
    public void putAndGet() {
        Customer customer=new Customer();
        customer.setName("lesline");
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
    @Test
    public void putAndGetObject() {

        Jedis jedis = new Jedis("localhost");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
