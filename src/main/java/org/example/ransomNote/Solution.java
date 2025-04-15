package org.example.ransomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count = ransomNote.length();
        Map<Character, Integer> ransomNoteMap = new HashMap();

        for (char c : ransomNote.toCharArray()) {
            ransomNoteMap.put(c, ransomNoteMap.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            Integer leftCharCount = ransomNoteMap.get(c);
            if (leftCharCount != null && leftCharCount > 0) {
                ransomNoteMap.put(c, --leftCharCount);
                count--;
            }
            if (count == 0) {
                break;
            }
        }

        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
