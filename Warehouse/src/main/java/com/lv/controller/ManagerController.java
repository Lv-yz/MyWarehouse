package com.lv.controller;

import com.lv.pojo.Customer;
import com.lv.pojo.Manager;
import com.lv.service.CustomerService;
import com.lv.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ManagerController {
    @Autowired
    @Qualifier("managerServiceImpl")
    private ManagerService managerService;
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @RequestMapping("/exit")
    public String exitSys(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        System.out.println("退出!");

        request.getSession().setAttribute("manager",null);
        model.addAttribute("warm","");
        return "../../index";
    }
    @RequestMapping("/torePassword")
    public String toRePassowrd(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        System.out.println("修改密码!");
        return "repassword";
    }
    @RequestMapping("/repassword")
    public String rePassword(String id,String oldPassword,String newPassword,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        查看操作
        Manager manager = managerService.selectManagerById(id);
        if(manager != null){
            //        执行操作
            managerService.updateManager(id,oldPassword,newPassword);

            manager = managerService.selectManagerById(id);
            if(manager != null){
                model.addAttribute("tip","密码修改成功!");
            }else{
                model.addAttribute("tip","密码修改失败!");
            }
        }else{
            model.addAttribute("tip","原密码错误!");
        }
//        添加数据
        Customer[] customers = customerService.selectAllCustomer();
        model.addAttribute("customers",customers);
//        返回界面
        return "repassword";
    }
}
