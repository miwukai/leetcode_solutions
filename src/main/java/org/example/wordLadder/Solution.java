package org.example.wordLadder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordStep> changeSequence = new LinkedList();

        changeSequence.offer(new WordStep(beginWord, 1));

        Set<String> visited = new HashSet<String>();

        while (!changeSequence.isEmpty()) {
            WordStep wordStep = changeSequence.poll();

            if (checkDiff(wordStep.word, endWord) == 0) {
                return wordStep.step;
            }

            for (String word : wordList) {
                if (!visited.contains(word)) {
                    if (checkDiff(wordStep.word, word) == 1) {
                        changeSequence.offer(new WordStep(word, wordStep.step + 1));
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

    int checkDiff(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int diff = 0;

        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] != bChar[i]) {
                diff++;
            }
        }
        return diff;
    }

    class WordStep {
        String word;
        Integer step;

        WordStep(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.checkDiff("dog", "cog"));

        String beginWord = "hit", endWord = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(words)));
    }
}
