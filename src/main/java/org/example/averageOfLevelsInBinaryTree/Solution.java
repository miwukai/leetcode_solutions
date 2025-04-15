package org.example.averageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, int[]> map = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        putToMap(root, 1);

        List<Double> result = new ArrayList<>();

        for(int i = 1; i <= map.size(); i++) {
            int[] arr = map.get(i);
            double avg = (double) arr[1] / arr[0];
            result.add(avg);
        }

        return result;

    }

    void putToMap(TreeNode node, int val) {
        if(node == null) return;

        if(map.containsKey(val)) {
            int[] arr = map.get(val);
            arr[0]++;
            arr[1] += node.val;
        } else {
            map.put(val, new int[]{1, node.val});
        }

        putToMap(node.left, val + 1);
        putToMap(node.right, val + 1);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.left.left = solution.new TreeNode(15);
        root.left.right = solution.new TreeNode(7);

        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result); // Output: [3.0, 14.5, 11.0]
    }
}
