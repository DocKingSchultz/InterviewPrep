package BinaryTree;

//Maximum Depth of Binary Tree
//Given the root of a binary tree, return its depth.
//
//The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        Example 1:

//Input: root = [1,2,3,null,null,4]
//
//Output: 3

public class MaxDepth {
    int currentMax = 0;
    public int maxDepth(TreeNode root) {
        return recursMaxDepth(root);
    }
    public int recursMaxDepth(TreeNode root)
    {
        if (root == null) return 0; // If the node is null, depth is 0

        // Recursively get the depth of the left and right subtrees
        int leftMax = recursMaxDepth(root.left);
        int rightMax = recursMaxDepth(root.right);

        // The depth of the current tree is 1 + the maximum of the left and right depths
        return Math.max(leftMax, rightMax) + 1;
    }
}
