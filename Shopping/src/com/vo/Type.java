package com.vo;

public class Type {
    private int tId;
    private String tName;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Type(int tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public Type(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                '}';
    }
}
