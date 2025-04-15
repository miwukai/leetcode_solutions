package org.example.kthSmallestElementInABST;

import java.util.Stack;

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

    Stack<TreeNode> st = new Stack();

    TreeNode prev = new TreeNode();

    public int kthSmallest(TreeNode root, int k) {

        Integer result = null;

        TreeNode node = root;

        while (node != null) {
            st.push(node);
            prev = node;
            node = node.left;
        }

        while (k > 0){
            node = st.pop();
            k--;
            if(k == 0){
                result = node.val;
                break;
            }
            if(node.right != null){
                node = node.right;
                while (node != null) {
                    st.push(node);
                    prev = node;
                    node = node.left;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(1);
        root.left.right = solution.new TreeNode(3);

        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + result);
    }
}
