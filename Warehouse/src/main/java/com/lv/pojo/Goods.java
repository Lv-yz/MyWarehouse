package com.lv.pojo;

public class Goods {
    private String goodsId;
    private String goodsName;
    private String goodsType;
    private double goodsValue;
    private String goodsPaper;

    public Goods() {
    }

    public Goods(String goodsId, String goodsName, String goodsType, double goodsValue, String goodsPaper) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsValue = goodsValue;
        this.goodsPaper = goodsPaper;
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

    public double getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(double goodsValue) {
        this.goodsValue = goodsValue;
    }

    public String getGoodsPaper() {
        return goodsPaper;
    }

    public void setGoodsPaper(String goodsPaper) {
        this.goodsPaper = goodsPaper;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsValue=" + goodsValue +
                ", goodsPaper='" + goodsPaper + '\'' +
                '}';
    }
}
