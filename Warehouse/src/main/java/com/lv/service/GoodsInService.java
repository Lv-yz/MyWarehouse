package com.lv.service;

import com.lv.pojo.StackInOrder;

public interface GoodsInService {
    //    查询所有
    public StackInOrder[] selectAllStackInOrder();
    //    通过入库id获取入库单
    public StackInOrder selectStackInOrderByGoodInId(String id);
    //    查询某个货物的所有入库
    public StackInOrder[] selectStackInOrderByGoodId(String id);
    //    查询某个供应商的所有入库
    public StackInOrder[] selectStackInOrderByProviderId(String id);
    //    插入入库信息
    public void insertGoodsIn(StackInOrder stackInOrder);
//    通过id删除入库单
    public void deleteStackInOrderByGoodInId(String id);
}
