package com.ygdxd.DP;

/**
 * @author Created by ygdxd_admin at 2019-04-02 2:22 PM
 */
public class LC55CanJump {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1){
            return false;
        }

        int n = 1;

        for (int i = nums.length - 2 ; i >= 0 ; i--){
            if (nums[i] >= n){
                n = 1;
            }else {
                n ++;
            }

            if (i == 0 && n > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,3,1,1,4};
        System.out.println(canJump(ints));
    }
}
