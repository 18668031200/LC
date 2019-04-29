package com.ygdxd.leetcode;

/**
 * @author Created by ygdxd_admin at 2019-04-26 8:41 PM
 */
public class LC213Rob {

    public static int rob(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        if (nums.length < 3){
            return nums[0];
        }

        int length = nums.length;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];

        dp1[0] = 0;
        dp2[0] = 0;

        for (int i = 1; i < length - 1; i++) {
            dp1[i + 1] = Math.max(dp1[i] ,dp1[i - 1] + nums[i]);
            dp2[i + 1] = Math.max(dp2[i] ,dp2[i - 1] + nums[i + 1]);
        }
        return Math.max(dp1[length - 1], dp2[length - 1]);

    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,1};
        System.out.println(rob(ints));
    }
}
