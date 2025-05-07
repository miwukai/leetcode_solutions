package org.example.maximalSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        int result = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == '1'){
                result = 1;
                dp[i][0] = 1;
            }
        }

        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == '1'){
                result = 1;
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1;
                    int c = dp[i - 1][j - 1];
                    if(c > 0){
                        int x = 1;
                        while(x <= Math.sqrt(c)){
                            if(matrix[i - x][j] == '0' || matrix[i][j - x] == '0'){
                                break;
                            }
                            x++;
                        }
                        dp[i][j] = x * x;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        System.out.println(solution.maximalSquare(matrix));
    }
}
