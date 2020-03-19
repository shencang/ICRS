package com.shencangblue.design.icrs.utils;

import java.util.Random;

public class StringUtils {
    public static String  getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i =0;i<length;i++){
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }
}
