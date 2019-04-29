package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-01 1:21 PM
 */
public class LC46Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        permutePart(0, nums, list);
        return list;
    }

    public static void permutePart(int n , int[] nums, List<List<Integer>> list){
        if (n == nums.length - 1){
            List<Integer> result = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
            }
            list.add(result);
            return;
        }

        for (int i = n; i < nums.length; i++) {
            swap(nums, i, n);
            permutePart(n + 1, nums, list);
            swap(nums, i, n);
        }
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[x] ^ nums[y];
        nums[x] = temp ^ nums[x];
        nums[y] = temp ^ nums[y];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,2};
        System.out.println(JSON.toJSONString(permute(ints)));
    }
}
