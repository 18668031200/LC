package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * zi ji 2
 * @author Created by ygdxd_admin at 2019-04-12 12:27 PM
 */
public class LC90SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        res.add(list);
        int left = 0, right = 1, len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                left = len;
            }else {
                left = 0;
            }
            right = res.size();
            len = res.size();
            for (int j = left; j < right; j++) {
                List<Integer> a = new ArrayList<>();
                a.addAll(res.get(j));
                a.add(nums[i]);
                res.add(a);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,2};
        System.out.println(JSON.toJSONString(subsetsWithDup(ints)));
    }
}
