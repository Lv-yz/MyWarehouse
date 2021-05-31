package com.lv.controller;

import com.lv.pojo.*;
import com.lv.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ToController {
    @Autowired
    @Qualifier("managerServiceImpl")
    private ManagerService managerService;
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;
    @Autowired
    @Qualifier("goodsOutServiceImpl")
    private GoodsOutService goodsOutService;
    @Autowired
    @Qualifier("providerServiceImpl")
    private ProviderService providerService;
    @Autowired
    @Qualifier("goodsInServiceImpl")
    private GoodsInService goodsInService;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private GoodController goodController;
    @Autowired
    private ManagerController managerController;
    @Autowired
    private OutboundOrderController outboundOrderController;
    @Autowired
    private ProviderController providerController;
    @Autowired
    private StackInOrderController stackInOrderController;



    @RequestMapping("/login")
    public String login(Manager manager, Model model, HttpServletRequest request){
//        打印提示
//        System.out.println("登陆!");
//        执行操作
        Manager manager1 = managerService.selectManager(manager);
        if(manager1 != null){
//            打印提示
//            System.out.println("登陆成功!");
//            数据
            model.addAttribute("man",manager1);
            Customer[] customers = customerService.selectAllCustomer();
            Customer[] customers1 = new Customer[customers.length>10?10:customers.length];
            System.arraycopy(customers,0,customers1,0,customers1.length);

            model.addAttribute("customers",customers1);
            HttpSession session = request.getSession();
            session.setAttribute("manager",manager1);
            //        数据
            model.addAttribute("pagecount",customers.length%10==0?customers.length/10:customers.length/10+1);
            model.addAttribute("currentpage",1);
            model.addAttribute("length",customers.length);
            return "customer";
        }
//        传递提示
        model.addAttribute("warm","账号或密码有误!");
        return "../../index";
    }
    @RequestMapping("/tocustomer")
    public String toCustomer(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        获取数据

        Customer[] customers = customerService.selectAllCustomer();
        Customer[] customers1 = new Customer[customers.length>10?10:customers.length];
        System.arraycopy(customers,0,customers1,0,customers1.length);

        model.addAttribute("customers",customers1);
        //        数据
        System.out.println(Arrays.toString(customers));
        model.addAttribute("pagecount",customers.length%10==0?customers.length/10:customers.length/10+1);
        model.addAttribute("currentpage",1);
        model.addAttribute("length",customers.length);
        return "customer";
    }
    @RequestMapping("/togood")
    public String toGood(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        model.addAttribute("man",model.getAttribute("man"));
//        获取数据
        Goods[] goods = goodsService.selectAllGoods();
        Goods[] goods1 = new Goods[goods.length>10?10:goods.length];
        System.arraycopy(goods,0,goods1,0,goods1.length);
        model.addAttribute("goods",goods1);

        model.addAttribute("pagecount",goods.length%10==0?goods.length/10:goods.length/10+1);
        model.addAttribute("currentpage",1);
        model.addAttribute("length",goods.length);

        return "good";
    }
    @RequestMapping("/tonewcustomer")
    public String toNewCustomer(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        return "newcustomer";
    }
    @RequestMapping("/tonewgood")
    public String toNewGood(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        return "newgood";
    }
    @RequestMapping("/tonewgoodsin")
    public String toNewGoodsIn(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        数据
        Goods[] goods = goodsService.selectAllGoods();
        Provider[] providers = providerService.selectAllProvider();
        model.addAttribute("goods",goods);
        model.addAttribute("providers",providers);
        return "newgoodsin";
    }
    @RequestMapping("/tonewgoodsout")
    public String toNewGoodsOut(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        数据
        Goods[] goods = goodsService.selectAllGoods();
        Customer[] customers = customerService.selectAllCustomer();
        model.addAttribute("goods",goods);
        model.addAttribute("customers",customers);
        return "newgoodsout";
    }
    @RequestMapping("/tonewprovider")
    public String toNewProvider(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        return "newprovider";
    }
    @RequestMapping("/toprovider")
    public String toProvider(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        数据
        Provider[] providers = providerService.selectAllProvider();
        Provider[] providers1 = new Provider[providers.length>10?10:providers.length];
        System.arraycopy(providers,0,providers1,0,providers1.length);
        model.addAttribute("providers",providers1);

        model.addAttribute("pagecount",providers.length%10==0?providers.length/10:providers.length/10+1);
        model.addAttribute("currentpage",1);
        model.addAttribute("length",providers.length);

        return "provider";
    }
    @RequestMapping("/tostackinorder")
    public String toStackInOrder(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        数据
        StackInOrder[] stackInOrders = goodsInService.selectAllStackInOrder();
        StackInOrder[] stackInOrders1 = new StackInOrder[stackInOrders.length>10?10:stackInOrders.length];
        System.arraycopy(stackInOrders,0,stackInOrders1,0,stackInOrders1.length);
        model.addAttribute("stackInOrders",stackInOrders1);

        model.addAttribute("pagecount",stackInOrders.length%10==0?stackInOrders.length/10:stackInOrders.length/10+1);
        model.addAttribute("currentpage",1);
        model.addAttribute("length",stackInOrders.length);

        return "stackinorder";
    }
    @RequestMapping("/tostackoutorder")
    public String toStackOutOrder(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        数据
        OutboundOrder[] outboundOrders = goodsOutService.selectAllOutboundOrder();
        OutboundOrder[] outboundOrders1 = new OutboundOrder[outboundOrders.length>10?10:outboundOrders.length];
        System.arraycopy(outboundOrders,0,outboundOrders1,0,outboundOrders1.length);

        model.addAttribute("outboundOrders",outboundOrders1);

        model.addAttribute("pagecount",outboundOrders.length%10==0?outboundOrders.length/10:outboundOrders.length/10+1);
        model.addAttribute("currentpage",1);
        model.addAttribute("length",outboundOrders.length);

        return "stackoutorder";
    }
    @RequestMapping("/toupdategood")
    public String toUpdateGood(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //打印提示
//        System.out.println("updategood");
//        System.out.println(id);
//        数据
        Goods goods = goodsService.selectGoodsById(id);
        model.addAttribute("goods",goods);
        return "updategood";
    }
    @RequestMapping("/toupdatecustomer")
    public String toUpdateCustomer(@RequestParam("id") String id, Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //打印提示
//        System.out.println("updatecustomer");
//        数据
        Customer customer = customerService.selectCustomerById(id);
        model.addAttribute("customer",customer);
        return "updatecustomer";
    }
    @RequestMapping("/toupdateprovider")
    public String toUpdateProvider(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //打印提示
//        System.out.println("updateprovider");
//        数据
        Provider provider = providerService.selectProviderById(id);
        model.addAttribute("provider",provider);
        return "updateprovider";
    }
    @RequestMapping("/toupdategoodsin")
    public String toUpdateGoodsIn(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //打印提示
//        System.out.println("updategoodsin");
//        数据
        StackInOrder stackInOrder = goodsInService.selectStackInOrderByGoodInId(id);
        model.addAttribute("stackInOrder",stackInOrder);
        return "updategoodsin";
    }
    @RequestMapping("/toupdategoodout")
    public String toUpdateGoodsOut(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //打印提示
//        System.out.println("updategoodsout");
//        数据
        OutboundOrder outboundOrder = goodsOutService.selectOutboundOrderByGoodOutId(id);
        model.addAttribute("outboundOrder",outboundOrder);
        return "updategoodsout";
    }

}
