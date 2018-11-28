package com.vo;

public class User {
    private int uId;
    private String userName;
    private String pwd;
    private String phone;
    private String idCard;
    private String email;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String userName, String pwd, String phone, String idCard, String email) {
        this.userName = userName;
        this.pwd = pwd;
        this.phone = phone;
        this.idCard = idCard;
        this.email = email;
    }

    public User(int uId, String userName, String pwd, String phone, String idCard, String email) {
        this.uId = uId;
        this.userName = userName;
        this.pwd = pwd;
        this.phone = phone;
        this.idCard = idCard;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
