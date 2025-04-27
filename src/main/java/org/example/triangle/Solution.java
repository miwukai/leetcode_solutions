package org.example.triangle;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        dp[0][0] = triangle.get(0).get(0);

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][triangle.get(i).size() - 1] = triangle.get(i).get(triangle.get(i).size() - 1)
                    + dp[i - 1][triangle.get(i - 1).size() - 1];
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }

            if (i == triangle.size() - 1) {
                for(int j = 0; j < triangle.get(i).size(); j++){
                    result = Math.min(result, dp[i][j]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> li0 = Arrays.asList(2);
        List<Integer> li1 = Arrays.asList(3, 4);
        List<Integer> li2 = Arrays.asList(6, 5, 7);
        List<Integer> li3 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> triangle = Arrays.asList(li0, li1, li2, li3);
        System.out.println(solution.minimumTotal(triangle));
    }
}
