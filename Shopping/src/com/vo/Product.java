package com.vo;

public class Product {
    private int pId;
    private String pName;
    private int tId;
    private double price;
    private String photo;
    private int pStock;
    private String detailed;
    private int pState;
    private int pOther;
    private String tName;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public int getpState() {
        return pState;
    }

    public void setpState(int pState) {
        this.pState = pState;
    }

    public int getpOther() {
        return pOther;
    }

    public void setpOther(int pOther) {
        this.pOther = pOther;
    }

    public Product() {
    }

    public Product(int pId, String pName, int tId, double price, String photo, int pStock, String detailed, int pState, int pOther) {
        this.pId = pId;
        this.pName = pName;
        this.tId = tId;
        this.price = price;
        this.photo = photo;
        this.pStock = pStock;
        this.detailed = detailed;
        this.pState = pState;
        this.pOther = pOther;
    }

    public Product(int pId, String pName, String tName, double price, String photo, int pStock, String detailed, int pState) {
        this.pId = pId;
        this.pName = pName;
        this.tName = tName;
        this.price = price;
        this.photo = photo;
        this.pStock = pStock;
        this.detailed = detailed;
        this.pState = pState;
    }

    public Product(int pId, String pName, int tId, double price, String photo, int pStock, String detailed, int pState) {
        this.pId = pId;
        this.pName = pName;
        this.tId = tId;
        this.price = price;
        this.photo = photo;
        this.pStock = pStock;
        this.detailed = detailed;
        this.pState = pState;
    }

    public Product(String pName, int tId, double price, String photo, int pStock, String detailed, int pState, int pOther) {
        this.pName = pName;
        this.tId = tId;
        this.price = price;
        this.photo = photo;
        this.pStock = pStock;
        this.detailed = detailed;
        this.pState = pState;
        this.pOther = pOther;
    }

    public Product(String pName, int tId, double price, String photo, int pStock, String detailed, int pState) {
        this.pName = pName;
        this.tId = tId;
        this.price = price;
        this.photo = photo;
        this.pStock = pStock;
        this.detailed = detailed;
        this.pState = pState;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", tId=" + tId +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", pStock=" + pStock +
                ", detailed='" + detailed + '\'' +
                ", pState=" + pState +
                ", pOther=" + pOther +
                '}';
    }
}
