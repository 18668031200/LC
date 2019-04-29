package com.ygdxd.DP;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @author Created by ygdxd_admin at 2019-03-22 1:33 PM
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] lis = new int[nums.length + 1];

        int x = 0;
        lis[x] = nums[0];
        for (int i : nums){
            if (i > lis[x]){
                lis[++x] = i;
            }else {
                int l = 0;
                int h = x;
                while (l < h){
                    int mid = (l + h) / 2;
                    if (lis[mid]>=i){
                        h = mid;
                    }else {
                        l = mid + 1;
                    }
                }
                lis[l] = i;
            }
        }
        return x + 1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4,10,4,3,8,9};
        int a =lengthOfLIS(ints);
        System.out.println(a);
    }
}
