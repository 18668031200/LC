package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Created by ygdxd_admin at 2019-04-01 1:56 PM
 */
public class LC47PermuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Map<String, Boolean> exist = new HashMap<>();
        permutePart(0, nums, list, exist);
        return list;
    }


    public static void permutePart(int n , int[] nums, List<List<Integer>> list, Map<String, Boolean> exist){
        if (n == nums.length - 1){
            List<Integer> result = new ArrayList<>(nums.length);
            StringBuilder builder = new StringBuilder(nums.length);
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
                builder.append(nums[i]);
            }
            if (exist.put(builder.toString(), true) == null){
                list.add(result);
            }
            return;
        }

        for (int i = n; i < nums.length; i++) {
            swap(nums, i, n);
            permutePart(n + 1, nums, list, exist);
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
        System.out.println(JSON.toJSONString(permuteUnique(ints)));
    }
}
