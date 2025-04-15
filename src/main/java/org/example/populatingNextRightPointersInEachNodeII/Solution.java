package org.example.populatingNextRightPointersInEachNodeII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Map<Integer, LinkedList> map = new HashMap<>();

    public Node connect(Node root) {
        if(root == null) return null;

        pushToMap(root,0);

        for (Map.Entry<Integer, LinkedList> entry : map.entrySet()) {
            List<Node> list = entry.getValue();
            for (int i = 0; i < list.size() - 1; i++) {
                Node node = list.get(i);
                node.next = list.get(i + 1);
            }
        }

        return root;
    }

    void pushToMap(Node node, int level){
        LinkedList<Node> list = map.getOrDefault(level, new LinkedList<Node>());
        list.add(node);
        map.put(level, list);
        pushToMap(node.left , level + 1);
        pushToMap(node.right, level + 1);
    }
}
