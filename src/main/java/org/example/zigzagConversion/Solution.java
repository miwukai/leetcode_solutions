package org.example.zigzagConversion;

public class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int n = 2 * numRows - 2;
        char[] charArray = s.toCharArray();
        int pairs = ((charArray.length % n) > 0 ? 1 : 0) + charArray.length / n;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j < pairs; j++) {
                if (i < n/2 && (j * n + i) < charArray.length) {
                    sb.append(charArray[j * n + i]);
                }
                if (i > 0 && (j * n + n - i) < charArray.length) {
                    sb.append(charArray[j * n + n - i]);
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}
