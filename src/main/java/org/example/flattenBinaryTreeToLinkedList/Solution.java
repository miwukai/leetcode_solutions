package org.example.flattenBinaryTreeToLinkedList;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode currentNode;

    public void flatten(TreeNode root) {
        if(root == null) return;
        currentNode = new TreeNode(root.val);
        TreeNode head = currentNode;
        flattenNode(root.left);
        flattenNode(root.right);
        root.left = null;
        root.right = head.right;
    }

    void flattenNode(TreeNode childNode){
        if(childNode == null) return;
        currentNode.right = new TreeNode(childNode.val);
        currentNode = currentNode.right;

        flattenNode(childNode.left);
        flattenNode(childNode.right);

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(4);
        root.right.right = solution.new TreeNode(6);

        solution.flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
