package deleteNodeInABST_450;

import model.TreeNode;

public class Solution {

	TreeNode nodeToBeDeleted = null;

	TreeNode parentNode = null;

	TreeNode maxNode = null;
	
	TreeNode maxNodeParent = null;
	
	TreeNode minNode = null;
	
	TreeNode minNodeParent = null;

	public TreeNode deleteNode(TreeNode root, int key) {

		findNode(null, root, key);

		if (nodeToBeDeleted != null) {
			if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
				if (parentNode == null) {
					root = null;
				} else if (parentNode.left != null && parentNode.left.val == nodeToBeDeleted.val) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			} else {
				if (nodeToBeDeleted.left != null) {
					findMaxNode(nodeToBeDeleted, nodeToBeDeleted.left);
					nodeToBeDeleted.val = maxNode.val;
					if(maxNodeParent.left != null && maxNodeParent.left.val == maxNode.val) {
						maxNodeParent.left = maxNode.left;
					}else {
						maxNodeParent.right = maxNode.left;
					}
				} else {
					findMinNode(nodeToBeDeleted, nodeToBeDeleted.right);
					nodeToBeDeleted.val = minNode.val;
					if(minNodeParent.right != null && minNodeParent.right.val == minNode.val) {
						minNodeParent.right = minNode.right;
					}else {
						minNodeParent.left = minNode.right;
					}
				}
			}

		}

		return root;

	}

	void findNode(TreeNode pNode, TreeNode root, int key) {
		if (root != null) {
			if (root.val != key) {
				findNode(root, root.left, key);
				findNode(root, root.right, key);
			} else {
				parentNode = pNode;
				nodeToBeDeleted = root;
			}
		}
	}

	void findMaxNode(TreeNode parent, TreeNode root) {
		if (root.right != null) {
			findMaxNode(root, root.right);
		} else {
			maxNodeParent = parent;
			maxNode = root;
		}
	}
	
	void findMinNode(TreeNode parent, TreeNode root) {
		if (root.left != null) {
			findMinNode(root, root.left);
		} else {
			minNodeParent = parent;
			minNode = root;
		}
	}

}
