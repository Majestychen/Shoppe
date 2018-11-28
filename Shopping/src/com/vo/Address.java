package com.vo;

public class Address {
    private int aId;
    private String aName;
    private String aPhone;
    private String address;
    private int uId;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public Address(int aId, String aName, String aPhone, String address, int uId) {
        this.aId = aId;
        this.aName = aName;
        this.aPhone = aPhone;
        this.address = address;
        this.uId = uId;
    }

    public Address(String aName, String aPhone, String address, int uId) {
        this.aName = aName;
        this.aPhone = aPhone;
        this.address = address;
        this.uId = uId;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aPhone='" + aPhone + '\'' +
                ", address='" + address + '\'' +
                ", uId=" + uId +
                '}';
    }
}
