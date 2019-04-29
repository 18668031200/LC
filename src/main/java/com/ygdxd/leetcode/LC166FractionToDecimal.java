package com.ygdxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-03-31 4:11 PM
 */
public class LC166FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return String.valueOf(0);
        }
        if (denominator == 0) {
            return "Nan";
        }

        boolean flag = (long)numerator * (long)denominator < 0;

        long newNumerator = Math.abs((long)numerator);
        long newdDenominator = Math.abs((long)denominator);
        //整数部分
        long part1 = newNumerator / newdDenominator;
        StringBuilder builder = new StringBuilder();
        builder.append(part1);
        long remainder = newNumerator % newdDenominator;
        if (remainder != 0){
            builder.append(".");
            StringBuilder decimalBuilder = new StringBuilder();
            List<Long> remainderList = new ArrayList<>();

            while (true){
                if (remainder == 0){
                    builder.append(decimalBuilder);
                    break;
                }
                if (remainderList.contains(remainder)){
                    int index = remainderList.indexOf(remainder);
                    if (index >= 1){
                        builder.append(decimalBuilder.substring(0, index)).append("(").append(decimalBuilder.substring(index)).append(")");
                    }else {
                        builder.append("(").append(decimalBuilder.toString()).append(")");
                    }
                    break;
                }else {
                    remainderList.add(remainder);
                    decimalBuilder.append((remainder * 10 / newdDenominator));
                    remainder = remainder * 10 % newdDenominator;
                }
            }
        }
        String result = builder.toString();
        return flag ? "-" + result : result;
    }

    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(fractionToDecimal(a, b));
    }
}
