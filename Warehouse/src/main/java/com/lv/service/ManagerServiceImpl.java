package com.lv.service;

import com.lv.dao.ManagerMap;
import com.lv.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerMap managerMap;

    public ManagerServiceImpl(ManagerMap managerMap) {
        this.managerMap = managerMap;
    }
    public ManagerMap getManagerMap() {
        return managerMap;
    }
    public void setManagerMap(ManagerMap managerMap) {
        this.managerMap = managerMap;
    }
    @Override
    public Manager selectManagerById(String id) {
        return managerMap.selectManagerById(id);
    }
    @Override
    public Manager selectManager(Manager manager) {
        return managerMap.selectManager(manager);
    }
    @Override
    public void updateManager(String id,String oldPassword, String newPassword) {
        managerMap.updateManager(id,oldPassword,newPassword);
    }
    @Override
    public Manager[] selectAllManager(){
        return managerMap.selectAllManager();
    };
}
