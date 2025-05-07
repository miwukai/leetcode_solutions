package org.example.maximalSquare;

public class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxLength = 0;

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxLength = Math.max(maxLength, dp[i][0]);
        }

        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxLength = Math.max(maxLength, dp[0][j]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        System.out.println(solution2.maximalSquare(matrix));
    }
}
