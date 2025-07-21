package org.example.findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList();

        int left = 0;

        int right = 0;

        int numOfCharLeftInP = p.length();

        Map<Character, Integer> numOfEachCharInP = new HashMap();

        char[] pChars = p.toCharArray();

        char[] schars = s.toCharArray();

        for(char c : pChars){
            if(numOfEachCharInP.containsKey(c)){
                numOfEachCharInP.put(c, numOfEachCharInP.get(c) + 1);
            } else {
                numOfEachCharInP.put(c, 1);
            }
        }

        Map<Character, Integer> m = resetMap(numOfEachCharInP);

        while(right < s.length()){

            char c = schars[right];

            if(m.containsKey(c)){

                int num = m.get(c);

                if(num > 0){
                    m.put(c, num - 1);
                    numOfCharLeftInP--;
                    if(numOfCharLeftInP == 0){
                        output.add(left);
                    }
                } else if (num == 0){
                    while(schars[left] != c){
                        if(m.containsKey(schars[left])){
                            m.put(schars[left], m.get(schars[left]) + 1);
                            numOfCharLeftInP++;
                        }

                        left++;
                    }
                    left++;

                    if(numOfCharLeftInP == 0){
                        output.add(left);
                    }
                }
            } else {
                left = right + 1;

                if(numOfCharLeftInP != p.length()){
                    numOfCharLeftInP = p.length();

                    m = resetMap(numOfEachCharInP);
                }
            }

            right++;

        }

        return output;
    }

    private Map<Character, Integer> resetMap(Map<Character, Integer> originalMap){
        Map<Character, Integer> m = new HashMap();

        originalMap.forEach((k,v) -> m.put(k, v));

        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abacbabc";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }
}
