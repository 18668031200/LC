package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author Created by ygdxd_admin at 2019-04-23 10:55 PM
 */
public class LC179LargestNumber {

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1){
            return "";
        }

        StringBuilder builder = new StringBuilder();
        
        int l = 0, h = nums.length - 1;
        quickSort(nums, l, h);

        
        for (int i : nums){
            builder.append(i);
        }
        String s = builder.toString();
        if (s.startsWith("0")){
            s = "0";
        }
        return s;
    }

    public static void quickSort(int[] nums, int l, int h){
        int temp = nums[l];

        int a = l;
        int b = h;

        while (l < h){
            while (compare(nums[h],temp) && l < h){
                h --;
            }
            nums[l] = nums[h];
            while (!compare(nums[l], temp) && l < h){
                l ++;
            }
            nums[h] = nums[l];
        }
        nums[l] = temp;

        if (a < l - 1){
            quickSort(nums, a, l - 1);
        }

        if (b > l + 1){
            quickSort(nums, l + 1, b);
        }
    }


    public static boolean compare(int a, int b){
        String as = String.valueOf(a);
        String bs = String.valueOf(b);

        return Long.valueOf(as + bs) <= Long.valueOf(bs + as);
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,7,9,12,45};
        System.out.println(largestNumber(ints));
    }
}
