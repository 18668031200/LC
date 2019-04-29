package com.ygdxd.leetcode;

import java.util.Arrays;

/**
 * @author Created by ygdxd_admin at 2019-04-10 2:09 PM
 */
public class LC875MinEatingSpeed {

    public static int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length < 1 || H < piles.length){
            return -1;
        }
        Arrays.sort(piles);
        int l = 1,h = 0;

        int length = piles.length;
        h = piles[length - H % length - 1];


        while (l < h){
            int mid = (l + h) / 2;
            if (enable(piles, H, mid)){
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean enable(int[] nums, int h, int k){
        int t = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] / k;
            int b = nums[i] % k == 0 ? 0 : 1;
            t += (a + b);
        }

        return t <= h;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{312884470};
        System.out.println(minEatingSpeed(ints, 968709470));
    }
}
