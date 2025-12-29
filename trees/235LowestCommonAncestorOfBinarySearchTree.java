package Trees;
/**
 * Definition for a binary tree node.
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parent = root.val;
        int pVal = p.val;
        int qVal = q.val;
        // lets check if p and q is more then ancestor is on right
        if (pVal > parent && qVal > parent) {
            return lowestCommonAncestor(root.right, p, q);
        } // otherwise its on right
        else if (pVal < parent && qVal < parent) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }

    }
}