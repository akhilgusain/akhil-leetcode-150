package Trees;

import java.util.HashMap;
import java.util.Map;

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
    int preOrderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre order traversal result tells about root node
        // in order traversal tell about left and right nodes
        // since traversing inorder wont give us much info we take hashmap help
        preOrderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null; // break case
        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;

        TreeNode root = new TreeNode(rootValue);
        // populate left and right subtree
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1); // refer inorder array
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right); // right side of root

        return root;
    }
}
