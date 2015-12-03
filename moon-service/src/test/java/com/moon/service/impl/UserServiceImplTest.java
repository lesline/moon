package com.moon.service.impl;

import com.moon.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 6, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Before
    public void before() throws Exception {
        System.out.println("--------------start----------------");

    }

    @After
    public void after() throws Exception {
        System.out.println("--------------end----------------");

    }

    /**
     * Method: getUsers(User user)
     */
    @Test
    public void testGetUsers() throws Exception {
        List<User> users = userServiceImpl.getUsers(new User());
        System.out.println(users);
    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userServiceImpl.selectByPrimaryKey(1);
        System.out.println(user);
    }

} 
