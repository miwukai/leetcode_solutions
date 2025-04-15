package org.example.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Character> m = new HashMap();

        for (int i = 0; i < sArray.length; i++) {

            if (m.containsKey(sArray[i])) {
                if (tArray[i] != m.get(sArray[i])) {
                    return false;
                }
            } else {
                m.put(sArray[i], tArray[i]);
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("badc", "baba"));
    }
}
