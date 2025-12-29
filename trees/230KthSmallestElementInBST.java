package Trees;

import java.util.ArrayList;

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
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return arr; // stop case
        inOrder(root.left, arr); // first left
        arr.add(root.val); // add root
        inOrder(root.right, arr); // then right
        return arr; // this will return sorted array i.e inorder traversed binary tree
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
}
