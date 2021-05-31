package com.lv.pojo;

//出库表实体类
public class GoodsOut {
    private String goodId;
    private String customerId;
    private String goodDate;
    private String goodValue;
    private String goodNum;

    public GoodsOut(String goodId, String customerId, String goodDate, String goodValue, String goodNum) {
        this.goodId = goodId;
        this.customerId = customerId;
        this.goodDate = goodDate;
        this.goodValue = goodValue;
        this.goodNum = goodNum;
    }

    public GoodsOut() {
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(String goodDate) {
        this.goodDate = goodDate;
    }

    public String getGoodValue() {
        return goodValue;
    }

    public void setGoodValue(String goodValue) {
        this.goodValue = goodValue;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    @Override
    public String toString() {
        return "GoodsOut{" +
                "goodId='" + goodId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", goodDate='" + goodDate + '\'' +
                ", goodValue='" + goodValue + '\'' +
                ", goodNum='" + goodNum + '\'' +
                '}';
    }
}
