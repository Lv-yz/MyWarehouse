package com.lv.service;

import com.lv.pojo.OutboundOrder;

public interface GoodsOutService {
    //    查询所有出库操作
    public OutboundOrder[] selectAllOutboundOrder();

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
