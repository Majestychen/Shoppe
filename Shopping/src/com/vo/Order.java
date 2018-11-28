package com.vo;

public class Order {

    private int oId;
    private String oNum;
    private int cId;
    private double sumPrice;
    private int oState;
    //送货时间
    private String deliveryDate;
    //收货时间
    private String receiptDate;
    private int aId;
    private int uId;
    private String photo;
    private String detailed;
    private double price;
    private int buy_num;

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

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getoState() {
        return oState;
    }

    public void setoState(int oState) {
        this.oState = oState;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public Order(int oId, String oNum, int cId, double sumPrice, int oState, String deliveryDate, String receiptDate, int aId, int uId, String photo, String detailed, double price, int buy_num) {
        this.oId = oId;
        this.oNum = oNum;
        this.cId = cId;
        this.sumPrice = sumPrice;
        this.oState = oState;
        this.deliveryDate = deliveryDate;
        this.receiptDate = receiptDate;
        this.aId = aId;
        this.uId = uId;
        this.photo = photo;
        this.detailed = detailed;
        this.price = price;
        this.buy_num = buy_num;
    }

    public Order(int oId, String oNum, int cId, double sumPrice, int oState, int uId){
        this.oId = oId;
        this.oNum = oNum;
        this.cId = cId;
        this.sumPrice = sumPrice;
        this.oState = oState;
        this.uId = uId;
    }

    public Order(int oId, String oNum, int cId, String deliveryDate, double sumPrice, int oState, int aId, int uId){
        this.oId = oId;
        this.oNum = oNum;
        this.cId = cId;
        this.deliveryDate = deliveryDate;
        this.sumPrice = sumPrice;
        this.oState = oState;
        this.aId = aId;
        this.uId = uId;
    }

    public Order(int oId, String oNum, int cId, String deliveryDate, String receiptDate, double sumPrice, int oState, int aId, int uId){
        this.oId = oId;
        this.oNum = oNum;
        this.cId = cId;
        this.deliveryDate = deliveryDate;
        this.receiptDate = receiptDate;
        this.sumPrice = sumPrice;
        this.oState = oState;
        this.aId = aId;
        this.uId = uId;
    }
    //查询
    public Order(String photo, String detailed, double price, int buy_num){
        this.photo = photo;
        this.detailed = detailed;
        this.price = price;
        this.buy_num = buy_num;
    }

    public Order(){}

    @Override
    public String toString() {
        return "Order{" +
                "photo='" + photo + '\'' +
                ", detailed='" + detailed + '\'' +
                ", price=" + price +
                ", buy_num=" + buy_num +
                '}';
    }
}
