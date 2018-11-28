package com.vo;

public class Buy_Cat {
    private int cId;
    private int pId;
    private String photo;
    private String detailed;
    private double price;
    private int buy_num;
    private int cState;
    private int uId;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public int getcState() {
        return cState;
    }

    public void setcState(int cState) {
        this.cState = cState;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Buy_Cat() {
    }

    public Buy_Cat(int cId, int pId, int buy_num, int cState, int uId) {
        this.cId = cId;
        this.pId = pId;
        this.buy_num = buy_num;
        this.cState = cState;
        this.uId = uId;
    }

    public Buy_Cat(int pId, int buy_num, int cState, int uId) {
        this.pId = pId;
        this.buy_num = buy_num;
        this.cState = cState;
        this.uId = uId;
    }

    public Buy_Cat(int cId, int pId, String photo,String detailed,double price,int buy_num){
        this.cId = cId;
        this.pId = pId;
        this.photo = photo;
        this.detailed = detailed;;
        this.price = price;
        this.buy_num = buy_num;
    }

    public Buy_Cat(int pId, String photo,String detailed,double price,int buy_num){
        this.pId = pId;
        this.photo = photo;
        this.detailed = detailed;;
        this.price = price;
        this.buy_num = buy_num;
    }

    @Override
    public String toString() {
        return "Buy_Cat{" +
                "cId=" + cId +
                ", pId=" + pId +
                ", photo='" + photo + '\'' +
                ", detailed='" + detailed + '\'' +
                ", price=" + price +
                ", buy_num=" + buy_num +
                ", cState=" + cState +
                ", uId=" + uId +
                '}';
    }
}
