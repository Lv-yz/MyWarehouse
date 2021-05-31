package com.lv.service;

import com.lv.dao.GoodsInMap;
import com.lv.pojo.GoodsIn;
import com.lv.pojo.StackInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInServiceImpl implements GoodsInService {
    @Autowired
    private GoodsInMap goodsInMap;

    public GoodsInServiceImpl(GoodsInMap goodsInMap) {
        this.goodsInMap = goodsInMap;
    }

    public GoodsInServiceImpl() {
    }

    @Override
    public StackInOrder[] selectAllStackInOrder() {
        return goodsInMap.selectAllStackInOrder();
    }

    @Override
    public StackInOrder selectStackInOrderByGoodInId(String id) {
        return goodsInMap.selectStackInOrderByGoodInId(id);
    }

    @Override
    public StackInOrder[] selectStackInOrderByGoodId(String id) {
        return goodsInMap.selectStackInOrderByGoodId(id);
    }

    @Override
    public StackInOrder[] selectStackInOrderByProviderId(String id) {
        return goodsInMap.selectStackInOrderByProviderId(id);
    }

    @Override
    public void insertGoodsIn(StackInOrder stackInOrder) {
        goodsInMap.insertGoodsIn(stackInOrder);
    }
    @Override
    public void deleteStackInOrderByGoodInId(String id){
        goodsInMap.deleteStackInOrderByGoodInId(id);
    }
}
