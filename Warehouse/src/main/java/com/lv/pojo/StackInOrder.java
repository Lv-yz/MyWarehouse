package com.lv.pojo;

import java.util.Date;

public class StackInOrder {
    private String goodsInId;
    private String goodsId;
    private String goodsName;
    private String goodsType;//货物类型
    private String providerId;
    private String providerName;
    private int StackInOrderValue;//入库单价
    private int StackInOrderNum;//入库数量
    private String goodsPaper;//单位
    private Date StackInOrderTime;


    public StackInOrder(String goodsInId, String goodsId, String goodsName, String goodsType, String providerId, String providerName, int stackInOrderValue, int stackInOrderNum, String goodsPaper, Date stackInOrderTime) {
        this.goodsInId = goodsInId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.providerId = providerId;
        this.providerName = providerName;
        StackInOrderValue = stackInOrderValue;
        StackInOrderNum = stackInOrderNum;
        this.goodsPaper = goodsPaper;
        StackInOrderTime = stackInOrderTime;
    }

    public StackInOrder() {
    }

    public String getGoodsInId() {
        return goodsInId;
    }

    public void setGoodsInId(String goodsInId) {
        this.goodsInId = goodsInId;
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

    public int getStackInOrderValue() {
        return StackInOrderValue;
    }

    public void setStackInOrderValue(int stackInOrderValue) {
        StackInOrderValue = stackInOrderValue;
    }

    public int getStackInOrderNum() {
        return StackInOrderNum;
    }

    public void setStackInOrderNum(int stackInOrderNum) {
        StackInOrderNum = stackInOrderNum;
    }

    public String getGoodsPaper() {
        return goodsPaper;
    }

    public void setGoodsPaper(String goodsPaper) {
        this.goodsPaper = goodsPaper;
    }

    public Date getStackInOrderTime() {
        return StackInOrderTime;
    }

    public void setStackInOrderTime(Date stackInOrderTime) {
        StackInOrderTime = stackInOrderTime;
    }

    @Override
    public String toString() {
        return "StackInOrder{" +
                "goodsInId='" + goodsInId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", providerId='" + providerId + '\'' +
                ", providerName='" + providerName + '\'' +
                ", StackInOrderValue=" + StackInOrderValue +
                ", StackInOrderNum=" + StackInOrderNum +
                ", goodsPaper='" + goodsPaper + '\'' +
                ", StackInOrderTime=" + StackInOrderTime +
                '}';
    }
}
