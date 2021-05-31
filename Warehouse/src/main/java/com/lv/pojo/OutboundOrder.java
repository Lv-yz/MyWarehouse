package com.lv.pojo;

import java.util.Date;

public class OutboundOrder {

    private String goodsOutId;
    private String goodsId;
    private String goodsName;
    private String goodsType;
    private String customerId;
    private String customerName;
    private int OutboundOrderValue;
    private int OutboundOrderNum;
    private String goodsPaper;
    private Date OutboundOrderTime;


    public OutboundOrder() {
    }

    public OutboundOrder(String goodsOutId, String goodsId, String goodsName, String goodsType, String customerId, String customerName, int outboundOrderValue, int outboundOrderNum, String goodsPaper, Date outboundOrderTime) {
        this.goodsOutId = goodsOutId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.customerId = customerId;
        this.customerName = customerName;
        OutboundOrderValue = outboundOrderValue;
        OutboundOrderNum = outboundOrderNum;
        this.goodsPaper = goodsPaper;
        OutboundOrderTime = outboundOrderTime;
    }

    @Override
    public String toString() {
        return "OutboundOrder{" +
                "goodsOutId='" + goodsOutId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", OutboundOrderValue=" + OutboundOrderValue +
                ", OutboundOrderNum=" + OutboundOrderNum +
                ", goodsPaper='" + goodsPaper + '\'' +
                ", OutboundOrderTime=" + OutboundOrderTime +
                '}';
    }

    public String getGoodsOutId() {
        return goodsOutId;
    }

    public void setGoodsOutId(String goodsOutId) {
        this.goodsOutId = goodsOutId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOutboundOrderValue() {
        return OutboundOrderValue;
    }

    public void setOutboundOrderValue(int outboundOrderValue) {
        OutboundOrderValue = outboundOrderValue;
    }

    public int getOutboundOrderNum() {
        return OutboundOrderNum;
    }

    public void setOutboundOrderNum(int outboundOrderNum) {
        OutboundOrderNum = outboundOrderNum;
    }

    public String getGoodsPaper() {
        return goodsPaper;
    }

    public void setGoodsPaper(String goodsPaper) {
        this.goodsPaper = goodsPaper;
    }

    public Date getOutboundOrderTime() {
        return OutboundOrderTime;
    }

    public void setOutboundOrderTime(Date outboundOrderTime) {
        OutboundOrderTime = outboundOrderTime;
    }

}
