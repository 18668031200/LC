package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;


/**
 * @author Created by ygdxd_admin at 2019-04-03 9:36 PM
 */
public class LC66PlusOne {

    public static int[] plusOne(int[] digits) {
        int[] array=null;
        int digitsLength=digits.length;
        int num=1;
        for(int i=1;i<=digitsLength;i++) {
            digits[digitsLength-i]=digits[digitsLength-i]+1;
            if(digits[digitsLength-i]==10) {
                digits[digitsLength-i]=0;
                if(digits[0]==0) {
                    array=new int[digitsLength+1];
                    array[0]=num;
                    for(int j=1;j<array.length;j++) {
                        array[j]=digits[j-1];
                    }
                    return array;
                }
            }else {
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{9,9,9,9,8,7,6,5,4,3,2,1,0};
        System.out.println(JSON.toJSONString(plusOne(ints)));
    }
}
