package com.ygdxd.rotate;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 * @author Created by ygdxd_admin at 2019-03-30 5:22 PM
 */
public class FindMin {

    public static int findMin(int[] nums) {

        if (nums == null || nums.length < 1){
            return -1;
        }

        int l = 0, h = nums.length - 1;

        int mid = 0;
        while (h > l){
            mid = (h + l) / 2;
            if (nums[mid] >= nums[l]){
                if (nums[mid] > nums[h]){
                    l = mid + 1;
                }else {
                    h = mid;
                }
            }else {
                h = mid;
            }
        }
        
        return nums[l];

    }

    public static int findMin2(int[] nums) {
        if (nums == null || nums.length < 1){
            return -1;
        }

        int l = 0, h = nums.length - 1;

        int mid = 0;
        while (h > l){
            mid = (h + l) / 2;
            if (nums[mid] > nums[h]){
                l = mid + 1;
            }else if (nums[mid] < nums[h]){
                h = mid;
            }else {
                h --;
            }
        }

        return nums[l];

    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,2};
        System.out.println(findMin2(ints));
    }
}
