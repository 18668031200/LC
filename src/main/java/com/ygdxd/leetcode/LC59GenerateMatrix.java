package com.ygdxd.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @author Created by ygdxd_admin at 2019-04-03 4:46 PM
 */
public class LC59GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int i = 1;
        int x = 0, y = 0;
        int a = x;
        int b = y;
        int xp = n - 1, yp = n-1;
        for (;i <= n * n;xp--,y++){
            a = x;
            b = y;
            while (b <= yp){
                matrix[a][b] = i;
                i++;
                b ++;
            }
            a = x + 1;
            b = yp;
            while (a <= xp){
                matrix[a][b] = i;
                i++;
                a++;
            }

            x++;
            yp--;

            a = xp;
            b = yp;
            while (b >= y){
                matrix[a][b] = i;
                i++;
                b--;
            }
            a = xp - 1;
            b = y;
            while (a >= x){
                matrix[a][b] = i;
                i++;
                a--;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateMatrix(4)));
    }
}
