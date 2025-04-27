package org.example.coinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for(int coin : coins){
            if(coin <= amount){
                dp[coin] = 1;
            }
        }

        for(int i = 0; i <= amount; i++){
            for(int coin : coins){
                if(i > coin && dp[i - coin] > 0){
                    if(dp[i] == 0){
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
