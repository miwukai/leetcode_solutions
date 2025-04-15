package org.example.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

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

    List<Integer> output = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {

        checkNode(root, 0);

        return output;
    }

    void checkNode(TreeNode node, int level) {
        if(node == null) return;

        if (output.size() <= level) {
            output.add(node.val);
        }

        checkNode(node.right, level + 1);
        checkNode(node.left, level + 1);
    }
}
