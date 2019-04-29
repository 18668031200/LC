package com.ygdxd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by ygdxd_admin at 2019-04-10 1:00 PM
 */
public class LC679JudgePoint24 {

    public boolean judgePoint24(int[] nums) {
        List<Double> result = new ArrayList<>();
        for (int v: nums) {
            result.add((double) v);
        }
        return solve(result);
    }

    private boolean solve(List<Double> nums) {
        if (nums.isEmpty()){
            return false;
        }

        if (nums.size() == 1){
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        int l = nums.size();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i != j){
                    List<Double> list = new ArrayList<>();
                    for (int k = 0; k < l; k++) {
                        if (k != i && k != j){
                            list.add(nums.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0){
                            list.add(nums.get(i) + nums.get(j));
                        }
                        if (k == 1){
                            list.add(nums.get(i) * nums.get(j));
                        }

                        if (k == 2){
                            list.add(nums.get(i) - nums.get(j));
                        }
                        if (k == 3){
                            if (nums.get(j) != 0){
                                list.add(nums.get(i) / nums.get(j));
                            }else {
                                continue;
                            }
                        }

                        if (solve(list)){
                            return true;
                        }

                        list.remove(list.size() - 1);
                    }
                }

            }

        }
        return false;
    }


}
