package com.ygdxd.DP;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author Created by ygdxd_admin at 2019-03-21 8:51 PM
 */
public class MaxProfit {

    public static int maxProfit(int k, int[] prices) {
        if(k <= 0 || prices == null){
            return 0;
        }

        if (k > prices.length / 2){
            return greedy(prices);
        }
        int[][][] profit = new int[prices.length][k][2];

        profit[0][0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                profit[i][j][1] = Math.max(profit[i-1][j][0]-prices[i], profit[i - 1][j][1]);
                profit[i][j][0] = Math.max(profit[i-1][j - 1][1] + prices[i], profit[i-1][j][0]);
            }
        }

        return profit[prices.length - 1][k - 1][0];

    }

    private static int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,3,5,0,0,3,1,4};
        int a = maxProfit(2, ints);
        System.out.println(a);
    }
}
