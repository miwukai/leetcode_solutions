package org.example.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList();
        Map<String,List<String>> strMap = new HashMap();

        for(String s : strs){
            int[] map = new int[26];
            for(char c : s.toCharArray()){
                map[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i]; j++){
                    sb.append((char)(i + 'a'));
                }
            }
            String key = sb.toString();

            List<String> list = strMap.getOrDefault(key, new ArrayList<>());
            list.add(s);

            strMap.put(key,list);
            
        }

        output.addAll(strMap.values());

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
