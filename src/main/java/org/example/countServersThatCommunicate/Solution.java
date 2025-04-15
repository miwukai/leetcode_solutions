package org.example.countServersThatCommunicate;

public class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    if (row[i] > 1 || col[j] > 1) {
                        count++;
                    }
                    if (col[j] == 2) {
                        boolean counted = false;
                        for (int m = 0; m < i; m++) {
                            if (grid[m][j] == 1 && row[m] > 1) {
                                counted = true;
                            }
                        }
                        if (!counted) {
                            count++;
                        }
                    }
                    if (row[i] == 2) {
                        boolean counted = false;
                        for (int n = 0; n < j; n++) {
                            if (grid[i][n] == 1 && col[n] > 1) {
                                counted = true;
                            }
                        }
                        if (!counted) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
