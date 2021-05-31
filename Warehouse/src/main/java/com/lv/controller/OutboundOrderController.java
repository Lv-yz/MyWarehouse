package com.lv.controller;

import com.lv.pojo.Customer;
import com.lv.pojo.Goods;
import com.lv.pojo.OutboundOrder;
import com.lv.pojo.StackInOrder;
import com.lv.service.CustomerService;
import com.lv.service.GoodsOutService;
import com.lv.service.GoodsOutServiceImpl;
import com.lv.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Controller
public class OutboundOrderController {
    @Autowired
    @Qualifier("goodsOutServiceImpl")
    private GoodsOutService goodsOutService;
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;
    @RequestMapping("newgoodout")
    public String newGoodOut(OutboundOrder outboundOrder,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        补全出库单
        outboundOrder.setOutboundOrderTime(new Date());
//        System.out.println(outboundOrder);
//        判断是否存在
        OutboundOrder outbound = goodsOutService.selectOutboundOrderByGoodOutId(outboundOrder.getGoodsOutId());
        if(outbound != null){
            model.addAttribute("tip","该出库单号已存在!");
//            数据
            Goods[] goods = goodsService.selectAllGoods();
            Customer[] customers = customerService.selectAllCustomer();
            model.addAttribute("goods",goods);
            model.addAttribute("customers",customers);
            return "newgoodsout";
        }
//        更新货物表
        Goods goods1 = goodsService.selectGoodsById(outboundOrder.getGoodsId());
        double d = goods1.getGoodsValue()-outboundOrder.getOutboundOrderNum();
        if(d < 0){
            model.addAttribute("tip","库存不足!");
//            数据
            Goods[] goods = goodsService.selectAllGoods();
            Customer[] customers = customerService.selectAllCustomer();
            model.addAttribute("goods",goods);
            model.addAttribute("customers",customers);
            return "newgoodsout";
        }
        goods1.setGoodsValue(d);
        goodsService.updateGoods(goods1);
//        插入出库单
        goodsOutService.insertGoodsOut(outboundOrder);
//        判断出库单是否插入成功
        outbound = goodsOutService.selectOutboundOrderByGoodOutId(outboundOrder.getGoodsOutId());
        if(outbound != null){
            System.out.println("出库单创建成功!");
            model.addAttribute("tip","出库单创建成功!");
        }else {
            System.out.println("出库单创建失败!");
            model.addAttribute("tip","出库单创建失败!");
        }
        System.out.println("newGoodOut");
//        数据
        Goods[] goods = goodsService.selectAllGoods();
        Customer[] customers = customerService.selectAllCustomer();
        model.addAttribute("goods",goods);
        model.addAttribute("customers",customers);
        return "newgoodsout";
    }
    @RequestMapping("deletegoodout")
    public String deleteGoodOut(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        打印提示
//        System.out.println("deleteGoodOut");
//        System.out.println(id);
//        执行操作
        goodsOutService.deleteGoodsOutByGoodOutId(id);
//        数据
        OutboundOrder[] outboundOrders = goodsOutService.selectAllOutboundOrder();
        model.addAttribute("outboundOrders",outboundOrders);
        return "stackoutorder";
    }
    @RequestMapping("/searchgoodout")
    public String searchGoodOut(String type,String keyword,int currentpage,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        打印提示
//        System.out.println("searchgoodin");
//        System.out.println(type);
//        System.out.println(keyword);

        OutboundOrder[] outboundOrders = null;
        switch (type){
            case "1": outboundOrders = goodsOutService.selectAllOutboundOrder();
                break;
            case "2":
                OutboundOrder outboundOrder = goodsOutService.selectOutboundOrderByGoodOutId(keyword);
                OutboundOrder[] s = new OutboundOrder[1];
                s[0] = outboundOrder;
                outboundOrders = s;
                break;
            case "3": outboundOrders = goodsOutService.selectOutboundOrderByGoodId(keyword);
                break;
            case "4": outboundOrders = goodsOutService.selectOutboundOrderByCustomerId(keyword);
                break;
            default:;
        }
        System.out.println(Arrays.toString(outboundOrders));

        model.addAttribute("pagecount",outboundOrders.length%10==0?outboundOrders.length/10:outboundOrders.length/10+1);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("length",outboundOrders.length);
//        Customer[] customers1 = new Customer[customers.length>10?10:cu];
        OutboundOrder[] outboundOrders1 = new OutboundOrder[outboundOrders.length-currentpage*10>0?10:outboundOrders.length-(currentpage-1)*10];
        System.arraycopy(outboundOrders,(currentpage-1)*10,outboundOrders1,0,outboundOrders1.length);

        model.addAttribute("outboundOrders",outboundOrders1);
        return "stackoutorder";
    }
}
