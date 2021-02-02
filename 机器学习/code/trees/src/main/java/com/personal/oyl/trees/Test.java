package com.personal.oyl.trees;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author OuYang Liang
 * @since 2021-02-01
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(13);
        BigDecimal b = BigDecimal.valueOf(3);


//        System.out.println(a.divide(b, MathContext.UNLIMITED));
        System.out.println(a.divide(b, MathContext.DECIMAL32));
        System.out.println(a.divide(b, MathContext.DECIMAL64));
        System.out.println(a.divide(b, MathContext.DECIMAL128));
        System.out.println(a.divide(b, 4, RoundingMode.HALF_UP));
    }
}
