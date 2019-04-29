package com.ygdxd.leetcode;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * @author Created by ygdxd_admin at 2019-03-31 2:10 PM
 */
public class LC162 {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1){
            return -1;
        }

        if (nums.length == 1){
            return 0;
        }

        int l = 0, h = nums.length - 1, mid = 0;

        while (l < h){


            mid = (l + h) / 2;
            if (mid == 0){
                return nums[l] > nums[h] ? l : h;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid - 1]){
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,1};
        System.out.println(findPeakElement(ints));
    }
}
