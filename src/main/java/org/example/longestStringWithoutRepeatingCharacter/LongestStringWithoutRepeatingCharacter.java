package org.example.longestStringWithoutRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charIndex = new HashMap();

        int result = 0;

        char[] chars = s.toCharArray();

        int startIndex = 0;

        if (chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (charIndex.containsKey(chars[i])) {
                if (startIndex <= charIndex.get(chars[i])) {
                    result = Math.max(result, i - charIndex.get(chars[i]));

                    startIndex = charIndex.get(chars[i]) + 1;
                } else {
                    result = Math.max(result, i - startIndex + 1);
                }
            } else {
                result = Math.max(result, i - startIndex + 1);
            }

            charIndex.put(chars[i], i);

        }

        return result;
    }
}
