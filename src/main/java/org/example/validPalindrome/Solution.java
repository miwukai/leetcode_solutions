package org.example.validPalindrome;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                list.add(Character.toLowerCase(c));
            }
        }

        Object[] charArray = list.toArray();

        for(int i = 0;i < 1 + charArray.length / 2;i++){
            if(charArray[i] != charArray[charArray.length - i - 1]){
                return false;
            }
        }

        return true;
    }
}
