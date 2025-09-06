package trees;

/**
 * Definition for a binary tree node.
 **/
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
    public int goodNodes(TreeNode root) {
        // here if a node is last i.e no left or right, we wont update maxSoFar variable
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int count = 0;
        // check if current node is good node
        if(node.val >= maxSoFar){ // if node is greater or equal than root or max node
            count = 1; // current node is a good node
            maxSoFar = node.val; // update the maximum value along the path
        }
        // count good nodes in the left and right subtree
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }
}
