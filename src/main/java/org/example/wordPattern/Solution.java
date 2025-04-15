package org.example.wordPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pArray = pattern.toCharArray();
        String[] sArray = s.split(" ");

        Map<Character, String> pTosMap = new HashMap();
        Map<String, Character> sTopMap = new HashMap();

        if(pArray.length != sArray.length){
            return false;
        }

        for (int i = 0; i < pArray.length; i++) {

            if (pTosMap.containsKey(pArray[i])) {
                if (!sArray[i].equals(pTosMap.get(pArray[i]))) {
                    return false;
                }
            } else {
                pTosMap.put(pArray[i], sArray[i]);
            }

            if (sTopMap.containsKey(sArray[i])) {
                if (pArray[i] != sTopMap.get(sArray[i])) {
                    return false;
                }
            } else {
                sTopMap.put(sArray[i], pArray[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.equals(a, b));
//        System.out.println((int)'c' - 'a');
    }
}
