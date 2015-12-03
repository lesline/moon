package com.moon.web.controller.customer;

import com.moon.model.Customer;
import com.moon.service.CustomerService;
import com.moon.web.model.GridData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lesline on 15/11/4.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customersback.json")
    @ResponseBody
    public GridData getCustomers(HttpServletRequest request, HttpServletResponse response) {
        GridData gridData = GridData.newInstance();
        Customer customer = new Customer();
        List<Customer> list = customerService.getCustomers(customer);
        Integer totalCount = customerService.getCustomersCount(customer);
        gridData.setData(list);
        gridData.setTotalCount(totalCount);
        gridData.setAsSuccess();
        System.out.println(gridData);
        return gridData;
    }

    @RequestMapping(value = "/customers.json")
    @ResponseBody
    public GridData getCustomer(@RequestParam(value = "page", required = true) Integer page,
                                @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                @RequestParam(value = "name", required = false) String name) {
        GridData gridData = GridData.newInstance();

        System.out.println(page + "|" + pageSize + "|" + name);

        Customer customer = new Customer();
        customer.setName(name);
        List<Customer> list = customerService.getCustomers(customer);
        Integer totalCount = customerService.getCustomersCount(customer);
        gridData.setData(list);
        gridData.setTotalCount(totalCount);
        gridData.setAsSuccess();
        System.out.println(gridData);
        return gridData;
    }


}
