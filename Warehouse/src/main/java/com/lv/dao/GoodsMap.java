package com.lv.dao;

import com.lv.pojo.Customer;
import com.lv.pojo.Goods;

public interface GoodsMap {
    //    获取所有货物信息
    public Goods[] selectAllGoods();
    //    通过id获取货物信息
    public Goods selectGoodsById(String id);
    //    通过id获取货物信息
    public Goods[] selectGoodsByName(String Name);
    //    通过id删除货物信息
    public void deleteGoodsById(String id);
    //    修改货物信息
    public void updateGoods(Goods goods);
    //    添加货物信息
    public void insertGoods(Goods goods);
}
