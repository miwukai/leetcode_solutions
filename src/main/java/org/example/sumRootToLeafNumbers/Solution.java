package org.example.sumRootToLeafNumbers;

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

    public int sumNumbers(TreeNode root) {

        if (root.left == null && root.right == null) return root.val;

        int result = doSum(root.left, root.val) + doSum(root.right, root.val);

        return result;
    }

    int doSum(TreeNode node, int num) {
        if (node == null) return 0;

        num = num * 10 + node.val;

        if (node.left == null && node.right == null) return num;

        return doSum(node.left, num) + doSum(node.right, num);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(0);
        root.left.left = solution.new TreeNode(5);
        root.left.right = solution.new TreeNode(1);
        System.out.println(solution.sumNumbers(root));
    }
}
