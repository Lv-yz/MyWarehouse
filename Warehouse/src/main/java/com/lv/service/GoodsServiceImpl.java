package com.lv.service;

import com.lv.dao.GoodsMap;
import com.lv.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMap goodsMap;

    public GoodsServiceImpl(GoodsMap goodsMap) {
        this.goodsMap = goodsMap;
    }

    public GoodsServiceImpl() {
    }

    @Override
    public Goods[] selectAllGoods() {
        return goodsMap.selectAllGoods();
    }

    @Override
    public Goods selectGoodsById(String id) {
        return goodsMap.selectGoodsById(id);
    }

    @Override
    public Goods[] selectGoodsByName(String name){
        return goodsMap.selectGoodsByName(name);
    }

    @Override
    public void deleteGoodsById(String id) {
        goodsMap.deleteGoodsById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMap.updateGoods(goods);
    }

    @Override
    public void insertGoods(Goods goods) {
        goodsMap.insertGoods(goods);
    }
}
