package com.lv.pojo;

public class GoodsIn {
    private String goodId;
    private String providerId;
    private String goodDate;
    private String goodValue;
    private String goodNum;

    public GoodsIn(String goodId, String providerId, String goodDate, String goodValue, String goodNum) {
        this.goodId = goodId;
        this.providerId = providerId;
        this.goodDate = goodDate;
        this.goodValue = goodValue;
        this.goodNum = goodNum;
    }

    public GoodsIn() {
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
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
        return "GoodsIn{" +
                "goodId='" + goodId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", goodDate='" + goodDate + '\'' +
                ", goodValue='" + goodValue + '\'' +
                ", goodNum='" + goodNum + '\'' +
                '}';
    }
}
