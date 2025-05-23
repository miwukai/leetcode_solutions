package org.example.uniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else if(i == 0){
                    if(j > 0){
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if(j == 0){
                    if(i > 0){
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] obstacleGrid = {
            {1,0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid)); // Output: 2
    }
}
