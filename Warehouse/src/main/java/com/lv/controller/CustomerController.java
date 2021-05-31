package com.lv.controller;

import com.lv.pojo.Customer;
import com.lv.pojo.Provider;
import com.lv.pojo.StackInOrder;
import com.lv.service.CustomerService;
import com.lv.service.CustomerServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class CustomerController {
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @RequestMapping("newcustomer")
    public String newCustomer(Customer customer,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
        Customer customer1 = customerService.selectCustomerById(customer.getCustomerId());
        if(customer1 != null){
            model.addAttribute("tip","该客户已存在!");
            return "newcustomer";
        }
//        插入数据
        customerService.insertCustomer(customer);
//        查看是否插入成功
        customer1 =customerService.selectCustomerById(customer.getCustomerId());
        if(customer1 != null){
            model.addAttribute("tip","客户新建成功!");
        }else{
            model.addAttribute("tip","客户新建失败!");
        }
//        System.out.println("newCustomer");
        return "newcustomer";
    }
    @RequestMapping("deletecustomer")
    public String deleteCustomer(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        打印提示
//        System.out.println("deleteCustomer");
//        执行操作
        customerService.deleteCustomerById(id);
//        数据
        Customer[] customers = customerService.selectAllCustomer();
        model.addAttribute("customers",customers);
        return "customer";
    }
    @RequestMapping("updatecustomer")
    public String updateCustomer(Customer customer,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
        //打印提示
//        System.out.println("updateCustomer");
//        执行操作
        customerService.updateCustomer(customer);
//        数据
        Customer[] customers = customerService.selectAllCustomer();
        model.addAttribute("customers",customers);
        return "customer";
    }
    @RequestMapping("searchcustomer")
    public String searchCustomer(String type,String keyword,int currentpage,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        System.out.println("searchcustomer");
//        System.out.println(type);
//        System.out.println(keyword);
        Customer[] customers = null;
        switch (type){
            case "1":
                customers = customerService.selectAllCustomer();
                break;
            case "2":
                Customer customer = customerService.selectCustomerById(keyword);
                Customer[] c = new Customer[1];
                c[0] = customer;
                customers = c;
                break;
            case "3":
                customers = customerService.selectCustomerByName(keyword);
                break;
            default:;
        }
//        数据
        System.out.println(Arrays.toString(customers));
        model.addAttribute("pagecount",customers.length%10==0?customers.length/10:customers.length/10+1);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("length",customers.length);
//        Customer[] customers1 = new Customer[customers.length>10?10:cu];
        Customer[] customers1 = new Customer[customers.length-currentpage*10>0?10:customers.length-(currentpage-1)*10];
        System.arraycopy(customers,(currentpage-1)*10,customers1,0,customers1.length);

        model.addAttribute("customers",customers1);
        return "customer";
    }

}
