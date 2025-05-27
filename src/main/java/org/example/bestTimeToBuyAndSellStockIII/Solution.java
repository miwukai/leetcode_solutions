package org.example.bestTimeToBuyAndSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[][] profits = new int[len][len];

        int[] maxProfitI = new int[len];

        int[] maxProfitJ = new int[len];

        for(int i = 1; i < len; i++){
            maxProfitI[i] = maxProfitI[i - 1];
            for(int j = 0; j < i; j++){
                profits[i][j] = prices[i] - prices[j];
                maxProfitI[i] = Math.max(maxProfitI[i], profits[i][j]);
            }
        }

        for(int j = len - 2; j >= 0; j--){
            maxProfitJ[j] = maxProfitJ[j + 1];
            for(int i = len - 1; i > j; i--){
                maxProfitJ[j] = Math.max(maxProfitJ[j], profits[i][j]);
            }
        }

        int result = 0;

        for(int i = 0; i < len; i++){
            result = Math.max(result, maxProfitI[i] + (i == len - 1 ? 0 : maxProfitJ[i + 1]));
        }

        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = new int[]{7,6,4,3,1};

        System.out.println(solution.maxProfit(prices));
    }
}
