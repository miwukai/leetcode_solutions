package org.example.designAddAndSearchWordsDataStructure;

public class WordDictionary {
    class TrieNode{
        TrieNode[] nodes = new TrieNode[26];

        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        char[] charArray = word.toCharArray();

        TrieNode node = this.root;

        for(char c : charArray){
            int index = c - 'a';

            if(node.nodes[index] == null){
                node.nodes[index] = new TrieNode();
            }

            node = node.nodes[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    boolean search(TrieNode node, String word){
        if(node == null || word.isEmpty()){
            return false;
        }

        char[] charArray = word.toCharArray();

        int idx = 0;

        for(char c : charArray){
            if(c != '.'){
                int index = c - 'a';

                if(node.nodes[index] == null){
                    return false;
                }

                node = node.nodes[index];

                idx++;
            } else {
                idx++;
                for(TrieNode child : node.nodes){
                    if(child != null){
                        if(charArray.length == idx && child.isEnd){
                            return true;
                        }  else if(search(child, word.substring(idx))){
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        return node.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("ab");
        System.out.println(wordDictionary.search("a."));
    }
}
