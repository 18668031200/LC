package com.ygdxd.DP;

/**
 * @author Created by ygdxd_admin at 2019-03-22 5:05 PM
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null){

        }
        int[] a = new int[amount + 1];
        a[0] = 0;


        for (int i = 1; i < amount + 1; i++) {
            a[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && a[i - coins[j]] != -1){

                    a[i] = Math.min(a[i], a[i - coins[j]] + 1);
                }
                if (a[i] == Integer.MAX_VALUE){
                    a[i] = -1;
                }
            }

        }

        return a[amount];

    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }
}
