package com.lv.controller;

import com.lv.pojo.Goods;
import com.lv.pojo.Provider;
import com.lv.pojo.StackInOrder;
import com.lv.service.GoodsInService;
import com.lv.service.GoodsService;
import com.lv.service.ProviderService;
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
public class StackInOrderController {
    @Autowired
    @Qualifier("goodsInServiceImpl")
    private GoodsInService goodsInService;
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;
    @Autowired
    @Qualifier("providerServiceImpl")
    private ProviderService providerService;

    @RequestMapping("newgoodin")
    public String newGoodIn(StackInOrder stackInOrder, Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        补全入库单
        stackInOrder.setStackInOrderTime(new Date());
//        打印入库单
//        System.out.println(stackInOrder);
//        查询是否存在
        StackInOrder stackInOrder1 = goodsInService.selectStackInOrderByGoodInId(stackInOrder.getGoodsId());
        if(stackInOrder1 != null){
            model.addAttribute("tip","该入库单号已存在!");
//            数据
            Goods[] goods = goodsService.selectAllGoods();
            Provider[] providers = providerService.selectAllProvider();
            model.addAttribute("goods",goods);
            model.addAttribute("providers",providers);
            return "newgoodsin";
        }
//        执行操作
        goodsInService.insertGoodsIn(stackInOrder);
//        更新货物表
        Goods goods1 = goodsService.selectGoodsById(stackInOrder.getGoodsId());
        goods1.setGoodsValue(goods1.getGoodsValue()+stackInOrder.getStackInOrderNum());
        goodsService.updateGoods(goods1);
//        判断是否插入成功
        stackInOrder1 = goodsInService.selectStackInOrderByGoodInId(stackInOrder.getGoodsId());
//        System.out.println("=========================");
//        System.out.println(stackInOrder1);
//        System.out.println("=========================");
        if(stackInOrder1 != null){
            System.out.println("入库单创建成功!");
            model.addAttribute("tip","入库单创建成功!");
        }else{
            System.out.println("入库单创建失败!");
            model.addAttribute("tip","入库单创建失败!");
        }
//        System.out.println("newGoodIn");
//        数据
        Goods[] goods = goodsService.selectAllGoods();
        Provider[] providers = providerService.selectAllProvider();
        model.addAttribute("goods",goods);
        model.addAttribute("providers",providers);
        return "newgoodsin";
    }
    @RequestMapping("deletegoodin")
    public String deleteGoodIn(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
//        打印数据
//        System.out.println("deleteGoodIn");
//        System.out.println(id);
//        执行操作
        goodsInService.deleteStackInOrderByGoodInId(id);
//        数据
        StackInOrder[] stackInOrders = goodsInService.selectAllStackInOrder();
        model.addAttribute("stackInOrders",stackInOrders);
        return "stackinorder";
    }
    @RequestMapping("/searchgoodin")
    public String searchGoodIn(String type,String keyword,int currentpage,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        System.out.println("searchgoodin");
        StackInOrder[] stackInOrders = null;
        switch (type){
            case "1": stackInOrders = goodsInService.selectAllStackInOrder();
                break;
            case "2":
                StackInOrder stackInOrder = goodsInService.selectStackInOrderByGoodInId(keyword);
                StackInOrder[] s = new StackInOrder[1];
                s[0] = stackInOrder;
                stackInOrders = s;
                break;
            case "3": stackInOrders = goodsInService.selectStackInOrderByGoodId(keyword);
                break;
            case "4": stackInOrders = goodsInService.selectStackInOrderByProviderId(keyword);
                break;
            default:;
        }
//        数据
        System.out.println(Arrays.toString(stackInOrders));

        StackInOrder[] stackInOrders1 = new StackInOrder[stackInOrders.length-currentpage*10>0?10:stackInOrders.length-(currentpage-1)*10];
        System.arraycopy(stackInOrders,(currentpage-1)*10,stackInOrders1,0,stackInOrders1.length);


        model.addAttribute("stackInOrders",stackInOrders1);
        model.addAttribute("pagecount",stackInOrders.length%10==0?stackInOrders.length/10:stackInOrders.length/10+1);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("length",stackInOrders.length);
        return "stackinorder";
    }
}
