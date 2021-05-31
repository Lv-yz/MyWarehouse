package com.lv.pojo;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerTel;
    private String customerAddress;

    public Customer(String customerId, String customerName, String customerTel, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.customerAddress = customerAddress;
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
