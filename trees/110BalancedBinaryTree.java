package Trees;

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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // tree is balanced if |left - right| less than 1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        // for root we have calculated now lets got to left and right
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int calculateHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
