package Trees;
import java.util.*;

/**
 * Definition for a binary tree node
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

// we will use breadth first search i.e adding each element based on its level
// i.e height

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void order(TreeNode node, int level) {
        if (ans.size() == level) { // initialize new array
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val); // otherwise just add to arraylist

        if (node.left != null)
            order(node.left, level + 1); // go left after adding root and increase level
        if (node.right != null)
            order(node.right, level + 1); // go right and increase level

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return ans;
        order(root, 0);
        return ans;
    }
}
