package test;

import com.lv.dao.CustomerMap;
import com.lv.pojo.Customer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerMapTest {
    @Test
    public void customerTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        CustomerMap customerMap = (CustomerMap) context.getBean("customerMap");

//        获取所有客户
        Customer[] customers = customerMap.selectAllCustomer();
        System.out.println("所有客户!");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
//        添加客户
        customerMap.insertCustomer(new Customer("1202","天蓝","43843419","中国北京"));
        customerMap.insertCustomer(new Customer("1203","天蓝","43843419","中国北京"));
        System.out.println("添加客户!");
        customers = customerMap.selectAllCustomer();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
//        获取指定客户
        Customer customer = customerMap.selectCustomerById("1201");
        System.out.println("获取指定客户!");
        System.out.println(customer);
//        更新客户
        customerMap.updateCustomer(new Customer("1201","金蓝","43843419","中国北京"));
        System.out.println("更新客户!");
        customers = customerMap.selectAllCustomer();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }

//        删除客户
        customerMap.deleteCustomerById("1202");
        System.out.println("删除客户!");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
    }
}
