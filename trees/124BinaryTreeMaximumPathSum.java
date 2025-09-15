package trees;
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
    // any node we encounter we have to find either left or right path and go with
    // max sum
    // initialize the maxSum variable
    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null)
            return 0; // terminating case for recursion

        // for any given node calculate leftGain and rightGain
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;
        // we calculate sum i.e node value and either left or right gain
        maxSum = Math.max(priceNewPath, maxSum);
        // for recursion we have to return maxGain value
        return node.val + Math.max(leftGain, rightGain);

    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}