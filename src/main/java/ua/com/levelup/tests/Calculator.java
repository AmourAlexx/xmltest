package ua.com.levelup.tests;

import java.math.BigDecimal;

public class Calculator {

    public static double mult(double a, double b){
        return a*b;
    }

    public static double multBD(double a, double b){
        BigDecimal aa = new BigDecimal(a);
        BigDecimal bb = new BigDecimal(b);
        return aa.multiply(bb).doubleValue();
    }
}
