package org.example.bestTimeToBuyAndSellStockIV;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}

