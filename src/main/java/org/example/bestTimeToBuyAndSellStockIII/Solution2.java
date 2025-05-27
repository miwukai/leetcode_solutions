package org.example.bestTimeToBuyAndSellStockIII;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int k = 2;

        int[][] dp = new int[k + 1][len];

        for (int i = 1; i <= k; i++) {
            int tempMax = dp[i - 1][0] - prices[0];

            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tempMax + prices[j]);
                tempMax = Math.max(tempMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][len - 1];
    }
}
