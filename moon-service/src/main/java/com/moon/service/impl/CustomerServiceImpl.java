package com.moon.service.impl;

import com.moon.common.util.log.Debug;
import com.moon.dao.CustomerMapper;
import com.moon.model.Customer;
import com.moon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer selectByPrimaryKey(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    @Debug
    public List<Customer> getCustomers(Customer customer) {
        return customerMapper.queryByPage(customer);
    }

    @Override
    public Integer getCustomersCount(Customer customer) {
        return customerMapper.queryCountByPage(customer);

    }

}
