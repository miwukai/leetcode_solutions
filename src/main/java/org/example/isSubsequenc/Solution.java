package org.example.isSubsequenc;

public class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        boolean result = true;

        int j = 0;
        for(int i = 0; i < sChar.length; i++){
            while(j < tChar.length && sChar[i] != tChar[j]){
                j++;
            }
            if(j == tChar.length){
                result = false;
                break;
            }
        }

        return result;
    }
}
