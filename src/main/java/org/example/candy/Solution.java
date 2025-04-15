package org.example.candy;

public class Solution {
    public int candy(int[] ratings) {

        int candies = ratings.length;

        if (ratings.length == 1) {
            return 1;
        }

        int i = 1;

        while (i < ratings.length) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
            }

            int peak = 0;
            while (i < ratings.length && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            int valley = 0;
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            candies -= Math.min(peak, valley);
        }

        return candies;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1, 2, 2};
        System.out.println(solution.candy(ratings));
    }
}
