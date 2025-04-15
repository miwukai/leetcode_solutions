package org.example.substringWithConcatenationOfAllWords;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> result= new HashSet<>();

        Map<String, Integer> wordCount = new HashMap();

        for(String word : words){
            Integer count = wordCount.get(word);
            wordCount.put(word, count == null ? 1 : ++count);
        }

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;

        for(int i = 0 ;i < wordLength;i++){

            if(result.contains(i)){
                continue;
            }

            Map<String, Integer> tempWordCount = new HashMap();
            List<String> tempWords = new LinkedList();


            for (int j = i; j <= s.length() - wordLength;j += wordLength){
                String tempWord = s.substring(j,j + wordLength);
                if(!wordCount.containsKey(tempWord)){
                    tempWordCount.clear();
                    tempWords.clear();

                } else {
                    tempWords.add(tempWord);
                    Integer c = tempWordCount.get(tempWord);
                    if(c == null){
                        tempWordCount.put(tempWord,1);
                    } else {
                        tempWordCount.put(tempWord,++c);
                    }

                    while(tempWordCount.get(tempWord) > wordCount.get(tempWord)){
                        String removedWord = tempWords.remove(0);
                        tempWordCount.put(removedWord,tempWordCount.get(removedWord) - 1);
                    }

                    if(tempWords.size() == words.length){
                        result.add(j - (totalLength - wordLength));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }
}
