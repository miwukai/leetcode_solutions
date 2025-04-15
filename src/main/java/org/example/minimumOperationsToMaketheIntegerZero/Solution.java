package org.example.minimumOperationsToMaketheIntegerZero;

import java.util.LinkedHashMap;

public class Solution {
    public int makeTheIntegerZero(int num1, int num2) {

        long num1InLong = (long)num1;

        long num2InLong = (long)num2;

        int i = 1;

        while (num1InLong > num2InLong) {
            num1InLong = num1InLong - num2InLong;

            if (Long.bitCount(num1InLong) <= i && num1InLong >= i) {
                return i;
            }

            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makeTheIntegerZero(85,42));
    }

}
