package com.ygdxd.leetcode;

/**
 * @author Created by ygdxd_admin at 2019-04-09 9:32 AM
 */
public class LCSearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        return searchLine(matrix, 0 , target);
    }

    public static boolean searchLine(int[][] matrix, int x, int target){
        for (int i : matrix[x]){
            if (target == i){
                return true;
            }
            if (target < i){
                break;
            }
        }
        if (x < matrix.length - 1 && matrix[x + 1][0] <= target){
            return searchLine(matrix, x + 1, target);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,   4,  7, 11, 15},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10,   13,  14, 17, 24},
                new int[]{18,   21,  23, 26, 30},
        };
        System.out.println(searchMatrix(matrix, 20));
    }
}
