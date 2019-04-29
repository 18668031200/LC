package com.ygdxd.addNumber;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 1.开辟一个二维数组设num的长度为l  二维数组l*l l[x][y] = 0 - num[x] - num[y]
 *
 * @author Created by ygdxd_admin at 2018-07-02 下午9:33
 */
public class ThreeNumberDemo {

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.length < 3){
//            return result;
//        }
//        List<List<Integer>> str = new ArrayList<>(nums.length / 3);
//        int[][] matrix = new int[nums.length][nums.length];
//        int size  = nums.length;
//        boolean b =true;
//        for (int i = 0 ; i < size ; i++){
//            for (int j = i + 1 ; j < size  ; j ++){
//                for (int k = 0; k < size ; k++){
////                    matrix[i][j] = 0 - nums[i] - nums[j];
//                    if (nums[k] + nums[i] + nums[j] == 0 && k != i && k != j){
//                        for (List<Integer> list : str) {
//                            if (list.contains(nums[i]) && list.contains(nums[j]) && list.contains(nums[k])){
//
//                               if (nums[i] == 0 && nums[j] == 0 && !hasZeros(str)){
////                                   System.out.println(JSON.toJSONString(str));
//                                   break;
//                               }
//
//                                b = false;
//                                break;
//                            }
//                        }
//
//                        if (b){
//                            List<Integer> array = new ArrayList<>(3);
//                            array.add(nums[i]);
//                            array.add(nums[j]);
//                            array.add(nums[k]);
//                            result.add(array);
//                            List<Integer> ijk = new ArrayList<>(3);
//                            ijk.add(nums[i]);
//                            ijk.add(nums[j]);
//                            ijk.add(nums[k]);
//                            str.add(ijk);
//                        }
//                        b = true;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private static boolean hasZero(List<Integer> array){
//        if (!array.isEmpty()){
//            return array.stream().filter(s -> s == 0).count() > 1;
//        }
//        return false;
//    }
//
//    private static boolean hasZeros(List<List<Integer>> arrays){
//        boolean b = false;
//        for (List<Integer> list : arrays){
//            b = b || hasZero(list);
//            if (b){
//                return b;
//            }
//        }
//        return b;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int size = nums.length;
        quickSort(nums, 0, size - 1);
//        List<String> strs = new ArrayList<>(nums.length / 3);
        Set<List<Integer>> set = new HashSet<>();
        //判断是否有重复
        boolean b = false;

        int i = 0, j = 1, k = 2;
        //因为j始终是最大的 所有j必须>=0
        while (k < size && nums[k] < 0) {
            k++;
        }


        //同理 i 不能大于0
        while (i < size - 2 && nums[i] <= 0) {

            while (k < size) {
                while (j < k) {
                    if (nums[j] == nums[j - 1] && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list);
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }
                    j++;
                }

                j = i + 1;
                k++;
            }

            i++;

            while (i < size && nums[i] == nums[i - 1]) {
                i++;
            }

            j = i + 1;
            k = j + 1;

        }

        return set.stream().collect(Collectors.toList());
    }

    public static void quickSort(int[] nums, int i, int n) {
        if (nums == null || i >= n) {
            return;
        }

        int a;
        int key = nums[i];
        int j = i, k = n;

        while (j < k) {

            while (j < k && key <= nums[k]) {
                k--;
            }

            if (j < k) {
                a = nums[k];
                nums[k] = nums[j];
                nums[j] = a;
            }

            while (j < k && key >= nums[j]) {
                j++;
            }

            if (j < k) {
                a = nums[k];
                nums[k] = nums[j];
                nums[j] = a;
            }


        }


        if (j > i + 1) {
            quickSort(nums, i, j - 1);
        }

        if (j < n - 1) {
            quickSort(nums, j + 1, n);
        }


    }


    //[[-7,3,4],[-7,2,5],[-7,1,6],[-7,0,7],[-7,-1,8],[-7,-2,9],[-7,-3,10],[-7,-4,11],[-7,-5,12],[-7,-6,13],[-7,-7,14],[-6,3,3],[-6,2,4],[-6,1,5],[-6,0,6],[-6,-1,7],[-6,-2,8],[-6,-3,9],[-6,-4,10],[-6,-5,11],[-6,-6,12],[-5,2,3],[-5,1,4],[-5,0,5],[-5,-1,6],[-5,-2,7],[-5,-3,8],[-5,-4,9],[-5,-5,10],[-4,2,2],[-4,1,3],[-4,0,4],[-4,-1,5],[-4,-2,6],[-4,-3,7],[-4,-4,8],[-3,1,2],[-3,0,3],[-3,-1,4],[-3,-2,5],[-3,-3,6],[-2,1,1],[-2,0,2],[-2,-1,3],[-2,-2,4]]
    //[[-7,-7,14],[-7,-6,13],[-7,-5,12],[-7,-4,11],[-7,-3,10],[-7,-2,9],[-7,-1,8],[-7,0,7],[-7,1,6],[-7,2,5],[-7,3,4],[-6,-6,12],[-6,-5,11],[-6,-4,10],[-6,-3,9],[-6,-2,8],[-6,-1,7],[-6,0,6],[-6,1,5],[-6,2,4],[-6,3,3],[-5,-5,10],[-5,-4,9],[-5,-3,8],[-5,-2,7],[-5,-1,6],[-5,0,5],[-5,1,4],[-5,2,3],[-4,-4,8],[-4,-3,7],[-4,-2,6],[-4,-1,5],[-4,0,4],[-4,1,3],[-4,2,2],[-3,-3,6],[-3,-2,5],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-2,4],[-2,-1,3],[-2,0,2],[-2,1,1],[-1,-1,2],[-1,0,1]]
    public static void main(String[] args) {

//        int[] ints = new int[]{-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1};
//        quickSort(ints, 0, ints.length - 1);
        int[] ints = new int[]{-9, 14, -7, -8, 9, 1, -10, -8, 13, 12, 6, 9, 3, -3, -15, -15, 1, 8, -7, -4, -6, 8, 2, -10, 8, 11, -15, 3, 0, -11, -1, -1, 10, 0, 6, 5, -14, 3, 12, -15, -7, -5, 9, 11, -1, 1, 3, -15, -5, 11, -12, -4, -4, -2, -6, -10, -6, -6, 0, 2, -9, 14, -14, -14, -9, -1, -2, -7, -12, -13, -15, -4, -3, 1, 14, 3, -12, 3, 3, -10, -9, -1, -7, 3, 12, -6, 0, 13, 4, -15, 0, 2, 6, 1, 3, 13, 8, -13, 13, 11, 11, 13, 14, -6};
        System.out.println(JSON.toJSONString(threeSum(ints)));
    }

}
