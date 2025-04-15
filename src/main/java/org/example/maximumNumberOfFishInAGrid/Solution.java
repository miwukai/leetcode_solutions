package org.example.maximumNumberOfFishInAGrid;

public class Solution {

    public int findMaxFish(int[][] grid) {

        int[][] checked = new int[grid.length][grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (checked[i][j] == 0 && grid[i][j] > 0) {
                    count = Math.max(count, findNextFish(grid, i, j, checked));
                }
            }
        }
        return count;
    }

    public int findNextFish(int[][] grid, int i, int j, int[][] checked) {

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && checked[i][j] == 0 && grid[i][j] > 0) {
            checked[i][j] = 1;
            return grid[i][j] + findNextFish(grid, i - 1, j, checked) + findNextFish(grid, i + 1, j, checked) + findNextFish(grid, i, j + 1, checked) + findNextFish(grid, i, j - 1, checked);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{4, 0, 4}, {2, 3, 3}};
        System.out.println(solution.findMaxFish(grid));
    }
}
