package trees;

/**
 * Definition for a binary tree node.
 **/

class TreeNode {
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

class Solution {
    public Integer prev; // stores value of previous element

    public boolean isValidBST(TreeNode root) {
        // we dont have to look at one node and check its left and right and repeat
        // since it can be drawback
        // like if the right subtree might contain node which is less than root node
        // so optimal solution would be inorder traversal
        // if inorder traversal is performed in valid binary tree then result would be
        // sorted otherwise not
        prev = null;
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {
        // terminating case
        if (root == null)
            return true;
        // for inorder we call leftmost value
        if (!inOrder(root.left))
            return false; // if rule of BST is invalid return false

        // if root value is less than previous that means we found invalid BST
        if (prev != null && root.val <= prev)
            return false; // since its inorder then root should be > prev

        prev = root.val;
        return inOrder(root.right);

    }
}
