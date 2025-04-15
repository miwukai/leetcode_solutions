package org.example.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        if(s.equals(t)){
            return s;
        }

        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        String result = "";

        int left = 0;
        int charCount = t.length();
        for(int right = left;right < s.length() && left <= right;right++){
            Character rightChar = s.charAt(right);
            if(tMap.containsKey(rightChar)){
                if(tMap.put(rightChar, tMap.get(rightChar) - 1) > 0){
                    charCount--;
                }
            }

            if(charCount == 0){
                while(charCount == 0){
                    Character leftChar = s.charAt(left);
                    left++;
                    if(tMap.containsKey(leftChar)){
                        if(tMap.put(leftChar, tMap.get(leftChar) + 1) >= 0){
                            charCount++;
                        }
                    }
                }

                if(result == "" || result.length() > right - left + 2){
                    result = s.substring(left - 1, right + 1);
                }
            }


        }


        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("aaflslflsldkalskaaa", "aaa"));
    }
}
