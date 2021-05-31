package com.lv.controller;

import com.lv.pojo.Customer;
import com.lv.pojo.Goods;
import com.lv.pojo.Provider;
import com.lv.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class GoodController {
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;

    @RequestMapping("newgood")
    public String newGood(Goods goods,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        System.out.println(goods);
//        判断存在
        Goods goods1 = goodsService.selectGoodsById(goods.getGoodsId());
        if(goods1 != null){
            model.addAttribute("tip","该货物已存在!");
            return "newgood";
        }
//        执行操作
        goodsService.insertGoods(goods);
//        判断是否执行成功
        goods1 = goodsService.selectGoodsById(goods.getGoodsId());
        if(goods1 != null){
            model.addAttribute("tip","货物新建成功!");
        }else{
            model.addAttribute("tip","货物创建失败!");
        }
//        System.out.println("newGood");
        return "newgood";
    }
    @RequestMapping("deletegood")
    public String deleteGood(@RequestParam("id") String id,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        打印提示
//        System.out.println("deleteGood");
//        执行操作
        goodsService.deleteGoodsById(id);
//        数据
        Goods[] goods = goodsService.selectAllGoods();
        model.addAttribute("goods",goods);
        return "good";
    }
    @RequestMapping("updategood")
    public String updateGood(Goods goods,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        打印提示
//        System.out.println("updateGood");
//        执行操作
        goodsService.updateGoods(goods);
        Goods[] good = goodsService.selectAllGoods();
        model.addAttribute("goods",good);
        return "good";
    }
    @RequestMapping("searchgood")
    public String searchGood(String type,String keyword,int currentpage,Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("manager") == null){
            return "../../index";
        }
        //        设置管理员信息
//        model.addAttribute("man",model.getAttribute("man"));
//        System.out.println("searchgood");
//        System.out.println(type);
//        System.out.println(keyword);
        Goods[] goods = null;
        switch (type){
            case "1":
                goods = goodsService.selectAllGoods();
                break;
            case "2":
                Goods good = goodsService.selectGoodsById(keyword);
                Goods[] g = new Goods[1];
                g[0] = good;
                goods = g;
                break;
            case "3":
                goods = goodsService.selectGoodsByName(keyword);
                break;
            default:;
        }
//        System.out.println(Arrays.toString(goods));

        model.addAttribute("pagecount",goods.length%10==0?goods.length/10:goods.length/10+1);
        model.addAttribute("currentpage",currentpage);
        model.addAttribute("length",goods.length);
//        Customer[] customers1 = new Customer[customers.length>10?10:cu];
        Goods[] goods1 = new Goods[goods.length-currentpage*10>0?10:goods.length-(currentpage-1)*10];
        System.arraycopy(goods,(currentpage-1)*10,goods1,0,goods1.length);


        model.addAttribute("goods",goods1);
        return "good";
    }
}
