package com.lv.dao;

import com.lv.pojo.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ManagerMap {
//    查询用户名
    public Manager selectManagerById(@Param("MANAGER_ID") String id);
//    登陆查询
    public Manager selectManager(Manager manager);
//    修改密码操作
    public void updateManager(@Param("id") String id,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);
//    查询所有用户测试
    public Manager[] selectAllManager();
}
