package com.lv.service;

import com.lv.dao.CustomerMap;
import com.lv.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMap customerMap;

    public CustomerServiceImpl(CustomerMap customerMap) {
        this.customerMap = customerMap;
    }

    public CustomerServiceImpl() {
    }

    @Override
    public Customer[] selectAllCustomer() {
        return customerMap.selectAllCustomer();
    }

    @Override
    public Customer selectCustomerById(String id) {
        return customerMap.selectCustomerById(id);
    }

    @Override
    public Customer[] selectCustomerByName(String name){
        return customerMap.selectCustomerByName(name);
    }

    @Override
    public void deleteCustomerById(String id) {
        customerMap.deleteCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMap.updateCustomer(customer);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerMap.insertCustomer(customer);
    }
}
