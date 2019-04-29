package com.ygdxd.rotate;

import com.alibaba.fastjson.JSON;

/**
 * @author Created by ygdxd_admin at 2019-04-01 2:12 PM
 */
public class LC48RotateSquare {

    public static void rotate(int[][] matrix) {
        int l = 0;
        int h = matrix.length - 1;

        while (l <= h){
            int x = l;
            int y = h;
            while (x != h){
                int temp = matrix[y][l];
                matrix[y][l] = matrix[h][y];
                matrix[h][y] = matrix[x][h];
                matrix[x][h] = matrix[l][x];
                matrix[l][x] = temp;
                x ++;
                y --;
            }
            l ++;
            h --;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1,2,3,4,5},
                new int[]{6,7,8,9,10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,19,20},
                new int[]{21,22,23,24,25}
                
        };
        
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

}
