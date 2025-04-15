package org.example.chalkboardXORGame;

public class Solution {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 1) {
            int x = 0;
            for (int i : nums) {
                x = x ^ i;
            }
            if (x == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
