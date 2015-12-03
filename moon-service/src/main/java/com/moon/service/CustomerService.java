package com.moon.service;


import com.moon.model.Customer;

import java.util.List;

/**
 * Created by lesline on 15/11/6.
 */
public interface CustomerService {

    Customer selectByPrimaryKey(Integer id);

    List<Customer> getCustomers(Customer customer);
    Integer getCustomersCount(Customer customer);

}
