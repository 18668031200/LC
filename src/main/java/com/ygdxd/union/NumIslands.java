package com.ygdxd.union;

/**
 * @author Created by ygdxd_admin at 2019-03-25 5:46 PM
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int a = grid.length;
        int b = grid[0].length;

        int count = 0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == '1'){
                    fill(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private static void fill(char[][] grid, int i, int j){
        if (i <0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '1'){
            grid[i][j] = '0';
            fill(grid, i + 1, j);
            fill(grid, i, j + 1);
            fill(grid, i - 1, j);
            fill(grid, i, j - 1);
        }
    }



    public static void main(String[] args) {
        char[][] grid = new char[][]{
          new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'},
//                new char[]{'1','1','1','1','0'},
        };

        char[][] grid1 = new char[][]{
                new char[]{'1','1','1'},
                new char[]{'0','1','0'},
                new char[]{'1','1','1'}
        };
        System.out.println(numIslands(grid1));
    }
}
