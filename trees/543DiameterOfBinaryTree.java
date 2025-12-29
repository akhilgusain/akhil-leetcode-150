package Trees;

/**
 * Definition for a binary tree node.*/
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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter means sum of left and right height
        // so we will go through left and right and will add them
        // atlast we add 1 also since root is to be also considered 
        getHeight(root);
        return maxDiameter;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight); // this calculates max out of all

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
