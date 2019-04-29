package com.ygdxd.addNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.用hash
 * 2.用数组  位置为该数字缺的大小（target = 该位置+x）保存的值为数字的位置
 *
 * @author Created by ygdxd_admin at 2018-07-01 下午11:37
 */
public class Demo {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 6, 7, 9, 2, 2, 123, 11, 23, 14};
        System.out.print(twoSum(ints, 10)[0]);
    }

//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>(nums.length);
//        int[] result = new int[2];
//        for(int i = 0; i < nums.length ; i++){
//            if(map.containsKey(nums[i])){
//                result[0] = map.get(nums[i]);
//                result[1] = i;
//            }else {
//                map.put(target - nums[i], i);
//            }
//        }
//        return result;
//    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        if (nums == null || nums.length < 2) {
            return answer;
        }
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] difference = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {

            int other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (difference[other - min] > 0) {
                answer[0] = difference[other - min] - 1;
                answer[1] = i;
                return answer;
            }
            difference[nums[i] - min] = i + 1;
        }
        return answer;
    }
}
