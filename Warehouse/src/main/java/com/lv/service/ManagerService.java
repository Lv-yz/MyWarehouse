package com.lv.service;

import com.lv.pojo.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerService {
    //    查询用户名
    public Manager selectManagerById(@Param("MANAGER_ID") String id);
    //    登陆查询
    public Manager selectManager(Manager manager);
    //    修改密码操作
    public void updateManager(@Param("id") String id,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);
    public Manager[] selectAllManager();
}
