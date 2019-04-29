package com.ygdxd.linkedlist;

/**
 * @author Created by ygdxd_admin at 2019-02-12 5:31 PM
 */
public class SearchRotatedList {

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int low, int high, int target){
        if (low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target){
            return mid;
        }

        if (nums[low] <= nums[mid]){
            if (target >= nums[low] && target < nums[mid]){
                return search(nums, low, mid - 1, target);
            }else {
                return search(nums, mid + 1, high, target);
            }
        }else {
            if (target <= nums[high] && target > nums[mid]){
                return search(nums, mid + 1, high, target);
            }else {
                return search(nums, low, mid - 1, target);
            }
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null ||(nums.length == 1 && target != nums[0])){
            return new int[]{-1,-1};
        }
        return searchRange(nums, 0, nums.length - 1, target);
    }

    public static int[] searchRange(int[] nums,int start, int end, int target) {
        while (start <= end){
            int mid = (start + end) >> 1;
            if (nums[mid] == target){
                int a = mid;
                int b = mid;
                while (a - 1 >= start && nums[a - 1] == target){
                   a --;
                }
                while (b + 1 <= end && nums[b + 1] == target){
                    b ++;
                }
                return new int[]{a, b};
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{6,6,6}, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}
