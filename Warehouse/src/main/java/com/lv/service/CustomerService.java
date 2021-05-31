package com.lv.service;

import com.lv.pojo.Customer;

public interface CustomerService {
    //    获取所有用户信息
    public Customer[] selectAllCustomer();
    //    通过id获取客户信息
    public Customer selectCustomerById(String id);

    public Customer[] selectCustomerByName(String name);
    //    通过id删除客户信息
    public void deleteCustomerById(String id);
    //    修改客户信息
    public void updateCustomer(Customer customer);
    //    添加客户信息
    public void insertCustomer(Customer customer);
}
