package com.lv.pojo;

public class Provider {
    private String providerId;
    private String providerName;
    private String providerAddress;
    private String providerTel;

    public Provider(String providerId, String providerName, String providerAddress, String providerTel) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerTel = providerTel;
    }

    public Provider() {
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderTel() {
        return providerTel;
    }

    public void setProviderTel(String providerTel) {
        this.providerTel = providerTel;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId='" + providerId + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerAddress='" + providerAddress + '\'' +
                ", providerTel='" + providerTel + '\'' +
                '}';
    }
}
