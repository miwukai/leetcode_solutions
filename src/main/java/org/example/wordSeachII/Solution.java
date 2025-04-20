package org.example.wordSeachII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class TrieNode {
        TrieNode[] nodes;

        String word;

        TrieNode() {
            this.nodes = new TrieNode[26];
        }

        TrieNode(String word) {
            this.nodes = new TrieNode[26];

            this.word = word;
        }
    }

    TrieNode root = new TrieNode();

    void buildTrie(String word, TrieNode root) {
        char[] charArray = word.toCharArray();

        TrieNode node = root;

        for (char c : charArray) {
            int index = c - 'a';

            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }

            node = node.nodes[index];

        }

        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            buildTrie(word, root);
        }

        List<String> output = new ArrayList();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, output);

            }
        }

        return output;
    }

    void dfs(char[][] board, int i, int j, TrieNode node, List<String> output) {

        char c = board[i][j];

        if (c == '#') {
            return;
        }

        int idx = c - 'a';

        if (node.nodes[idx] != null) {

            if (node.nodes[idx].word != null) {
                output.add(node.nodes[idx].word);
                node.nodes[idx].word = null;
            }

            board[i][j] = '#';

            if (i > 0) {
                dfs(board, i - 1, j, node.nodes[idx], output);
            }

            if (i < board.length - 1) {
                dfs(board, i + 1, j, node.nodes[idx], output);
            }

            if (j > 0) {
                dfs(board, i, j - 1, node.nodes[idx], output);
            }

            if (j < board[0].length - 1) {
                dfs(board, i, j + 1, node.nodes[idx], output);
            }

            board[i][j] = c;
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a'}
        };

        String[] words = new String[]{"a"};

        Solution solution = new Solution();

        List<String> result = solution.findWords(board, words);

        result.forEach(System.out::println);
    }
}
