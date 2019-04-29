package com.ygdxd.bitmap;

import java.util.Arrays;

/**
 * @author Created by ygdxd_admin at 2019-02-12 10:23 PM
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1){
            return 1;
        }
        Arrays.sort(nums);
        int[] b = new int[nums[nums.length - 1]];
        for (int i : nums){
            if (i > 0){
                b[i - 1] = 1;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0){
                return i + 1;
            }
        }
        return b.length + 1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-8,-9,0,0,1,2,3,4,5,7,8};
        System.out.println(firstMissingPositive(new int[]{0,0,1,2}));
    }
}
