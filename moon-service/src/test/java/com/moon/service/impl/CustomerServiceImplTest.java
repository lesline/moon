package com.moon.service.impl;

import com.moon.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * CustomerServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 18, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class CustomerServiceImplTest {


    @Autowired
    private CustomerServiceImpl customerService;

    @Before
    public void before() throws Exception {
        System.out.println("--------------start----------------");

    }

    @After
    public void after() throws Exception {
        System.out.println("--------------end----------------");

    }

    /**
     * Method: selectByPrimaryKey(Integer id)
     */
    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Customer customer = customerService.selectByPrimaryKey(1);
        System.out.println(customer);
    }

    @Test
    public void testGetCustomers() {
        List<Customer> customerList = customerService.getCustomers(new Customer());
        System.out.println(customerList);
    }

} 
