package com.lv.dao;

import com.lv.pojo.Customer;
import com.lv.pojo.Goods;
import com.lv.pojo.Provider;

public interface ProviderMap {
    //    获取所有供应商信息
    public Provider[] selectAllProvider();
    //    通过id获取供应商信息
    public Provider selectProviderById(String id);
    //    通过id获取供应商信息
    public Provider[] selectProviderByName(String name);
    //    通过id删除供应商信息
    public void deleteProviderById(String id);
    //    修改供应商信息
    public void updateProvider(Provider provider);
    //    添加供应商信息
    public void insertProvider(Provider provider);
}
