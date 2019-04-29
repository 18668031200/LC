package com.ygdxd.DP;

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author Created by ygdxd_admin at 2019-04-02 1:48 PM
 */
public class LC53MaxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }

        int max = nums[0], cur = 0;

        for (int i : nums){
            cur = cur + i;
            if (cur < 0){
                cur = 0;
            }
                if (cur > max){
                    max = cur;
                }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-2,-1};
        System.out.println(maxSubArray(ints));
    }
}
