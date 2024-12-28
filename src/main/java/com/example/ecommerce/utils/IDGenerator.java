package com.example.ecommerce.utils;

import java.util.Random;

public class IDGenerator {
    public static long generateID(){
        long timestamp = System.currentTimeMillis();
        int randomNum = new Random().nextInt(999);
        return Long.parseLong(timestamp + "" + randomNum);
    }

}
