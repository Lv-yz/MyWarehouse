package com.lv.service;

import com.lv.dao.GoodsOutMap;
import com.lv.pojo.GoodsOut;
import com.lv.pojo.OutboundOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOutServiceImpl implements GoodsOutService {
    @Autowired
    private GoodsOutMap goodsOutMap;

    public GoodsOutServiceImpl(GoodsOutMap goodsOutMap) {
        this.goodsOutMap = goodsOutMap;
    }

    public GoodsOutServiceImpl() {
    }

    @Override
    public OutboundOrder[] selectAllOutboundOrder() {
        return goodsOutMap.selectAllOutboundOrder();
    }

    @Override
    public OutboundOrder selectOutboundOrderByGoodOutId(String id) {
        return goodsOutMap.selectOutboundOrderByGoodOutId(id);
    }

    @Override
    public OutboundOrder[] selectOutboundOrderByGoodId(String id) {
        return goodsOutMap.selectOutboundOrderByGoodId(id);
    }

    @Override
    public OutboundOrder[] selectOutboundOrderByCustomerId(String id) {
        return goodsOutMap.selectOutboundOrderByCustomerId(id);
    }

    @Override
    public void insertGoodsOut(OutboundOrder outboundOrder) {
        goodsOutMap.insertGoodsOut(outboundOrder);
    }
    @Override
    public void deleteGoodsOutByGoodOutId(String id){
        goodsOutMap.deleteGoodsOutByGoodOutId(id);
    }
}
