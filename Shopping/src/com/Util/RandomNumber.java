package com.Util;

public class RandomNumber {
    public static String randomNum (){
        String num = "";
        for (int i = 0; i < 9; i++) {
            num += (int)(Math.random() * 9+1);
        }
        return num;
    }
}
