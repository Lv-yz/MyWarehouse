package com.lv.dao;

import com.lv.pojo.Customer;
import com.lv.pojo.Goods;
import com.lv.pojo.OutboundOrder;
import com.lv.pojo.StackInOrder;

public interface GoodsOutMap {
//    查询所有出库操作
    public OutboundOrder[] selectAllOutboundOrder();
//    通过出库单查询操作
    public OutboundOrder selectOutboundOrderByGoodOutId(String id);
//    通过货物id查询所有的出库操作
    public OutboundOrder[] selectOutboundOrderByGoodId(String id);
//    通过客户id查询所有的出库操作
    public OutboundOrder[] selectOutboundOrderByCustomerId(String id);
//    插入出库操作
    public void insertGoodsOut(OutboundOrder outboundOrder);
//    通过id删除出库单
    public void deleteGoodsOutByGoodOutId(String id);
}
