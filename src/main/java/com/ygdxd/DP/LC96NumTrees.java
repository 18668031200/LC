package com.ygdxd.DP;

/**
 * @author Created by ygdxd_admin at 2019-04-04 7:28 PM
 */
public class LC96NumTrees {

    public static int numTrees(int n) {
        if (n < 2){
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
