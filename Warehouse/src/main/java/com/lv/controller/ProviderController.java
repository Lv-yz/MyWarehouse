package com.lv.controller;

import com.lv.pojo.OutboundOrder;
import com.lv.pojo.Provider;
import com.lv.service.ProviderService;
import com.lv.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class ProviderController {
    @Autowired
    @Qualifier("providerServiceImpl")
    private ProviderService providerService;

    @RequestMapping("newprovider")
    public String newProvider(Provider provider,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        打印提示
//        System.out.println(provider.toString());
//        判断是否供应商存在
        Provider provider1 = providerService.selectProviderById(provider.getProviderId());
        if(provider1 != null){
            model.addAttribute("tip","该供应商已存在");
            return "newprovider";
        }
//        执行操作
        providerService.insertProvider(provider);
//        判断是否插入成功
        provider1 = providerService.selectProviderById(provider.getProviderId());
        if(provider1 != null){
            model.addAttribute("tip","供应商创建成功!");
        }else{
            model.addAttribute("tip","供应商创建失败!");
        }
//        System.out.println("newProvider");
        return "newprovider";
    }
    @RequestMapping("deleteprovider")
    public String deleteProvider(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        System.out.println("deleteProvider");
//        System.out.println(id);
//        执行操作
        providerService.deleteProviderById(id);
//        数据
        Provider[] providers = providerService.selectAllProvider();
        model.addAttribute("providers",providers);
        return "provider";
    }
    @RequestMapping("updateprovider")
    public String updateProvider(Provider provider,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        提示信息
//        System.out.println("updateProvider");
//        执行操作
        providerService.updateProvider(provider);
//        数据
        Provider[] providers = providerService.selectAllProvider();
        model.addAttribute("providers",providers);
        return "provider";
    }
    @RequestMapping("/searchprovider")
    public String searchProvider(String type,String keyword,int currentpage,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        打印数据
//        System.out.println("searchprovider");
//        System.out.println(type);
//        System.out.println(keyword);
        Provider[] providers = null;
        switch (type){
            case "1":
                providers = providerService.selectAllProvider();
                break;
            case "2":
                Provider provider = providerService.selectProviderById(keyword);
                Provider[] p = new Provider[1];
                p[0] = provider;
                providers = p;
                break;
            case "3":
                providers = providerService.selectProviderByName(keyword);
                break;
            default:;
        }
        System.out.println(Arrays.toString(providers));

        model.addAttribute("pagecount",providers.length%10==0?providers.length/10:providers.length/10+1);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("length",providers.length);
//        Customer[] customers1 = new Customer[customers.length>10?10:cu];
        Provider[] providers1 = new Provider[providers.length-currentpage*10>0?10:providers.length-(currentpage-1)*10];
        System.arraycopy(providers,(currentpage-1)*10,providers1,0,providers1.length);


        model.addAttribute("providers",providers1);
        return "provider";
    }
}
