package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @author Created by ygdxd_admin at 2019-04-12 12:46 PM
 */
public class LC78Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        res.add(list);
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> a = new ArrayList<>();
                a.addAll(res.get(j));
                a.add(nums[i]);
                res.add(a);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3};
        System.out.println(JSON.toJSONString(subsets(ints)));
    }
}
