package org.example.huffmanEncoding;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int n = 4;

        char[] charArray = {'a', 'b', 'c', 'd'};

        int[] charfreq = {5, 1, 6, 3};

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new HuffmanComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.setCharacter(charArray[i]);
            hn.setFrequency(charfreq[i]);

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.setFrequency(x.getFrequency() + y.getFrequency());
            f.setLeft(x);
            f.setRight(y);

            root = f;

            q.add(f);
        }

        printCode(root, "");
    }

    private static void printCode(HuffmanNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getCharacter())) {
            System.out.println(root.getCharacter() + ":" + s);

            return;
        }

        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }
}
