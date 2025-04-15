package org.example.movingStonesUntilConsecutive;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b - a == 1 && c - b == 1) {
            return new int[]{0, 0};
        } else if (b - a <= 2 || c - b <= 2) {
            return new int[]{1, c - b - 1 + b - a - 1};
        } else {
            return new int[]{2, c - b - 1 + b - a - 1};
        }
    }
}
