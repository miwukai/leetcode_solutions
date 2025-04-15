package org.example.checkIfOneStringSwapCanMakeStringsEqual;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;

        int[] charPos = new int[2];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                if (charPos[0] == 0) {
                    charPos[0] = i;
                } else {
                    charPos[1] = i;
                }
            }
        }

        if (s1.charAt(charPos[0]) == s2.charAt(charPos[1]) && s1.charAt(charPos[1]) == s2.charAt(charPos[0])) {
            return true;
        }

        return false;

    }
}
