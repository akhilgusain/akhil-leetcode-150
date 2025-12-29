package Trees;


//       1          (depth 1)
//      / \
//     2   3       (depth 2)
//    / \
//   4   5         (depth 3)

/**
 * Definition for a binary tree node. **/
  class TreeNode {
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

class Solution {
    public int solve(TreeNode root, int depth){
        if(root == null) return depth;
        int left = solve(root.left, depth + 1);
        int right = solve(root.right, depth + 1);
        return Math.max(left, right);
    }
    public int maxDepth(TreeNode root) {
        return solve(root, 0);
    }
}