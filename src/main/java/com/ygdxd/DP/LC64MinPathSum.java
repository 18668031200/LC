package com.ygdxd.DP;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * @author Created by ygdxd_admin at 2019-04-03 9:20 PM
 */
public class LC64MinPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1){
            return 0;
        }
        int max = 0;

        int l1 = grid[0].length;
        int l2 = grid.length;

        for(int i = 1; i < l1; i++)
        {
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i < l2; i++)
        {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j],grid[i][j - 1]);
            }
        }

        return grid[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        };
        System.out.println(minPathSum(grid));
    }
}
