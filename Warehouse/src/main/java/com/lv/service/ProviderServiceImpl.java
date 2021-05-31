package com.lv.service;

import com.lv.dao.ProviderMap;
import com.lv.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMap providerMap;

    public ProviderServiceImpl(ProviderMap providerMap) {
        this.providerMap = providerMap;
    }

    public ProviderServiceImpl() {
    }
    @Override
    public Provider[] selectAllProvider() {
        return providerMap.selectAllProvider();
    }
    @Override
    public Provider selectProviderById(String id) {
        return providerMap.selectProviderById(id);
    }
    @Override
    public Provider[] selectProviderByName(String name) {
        return providerMap.selectProviderByName(name);
    }
    @Override
    public void deleteProviderById(String id) {
        providerMap.deleteProviderById(id);
    }
    @Override
    public void updateProvider(Provider provider) {
        providerMap.updateProvider(provider);
    }
    @Override
    public void insertProvider(Provider provider) {
        providerMap.insertProvider(provider);
    }
}
