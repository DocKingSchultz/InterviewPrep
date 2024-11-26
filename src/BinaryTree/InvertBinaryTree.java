package BinaryTree;

//Invert Binary Tree
//You are given the root of a binary tree root. Invert the binary tree and return its root.
//
//Example 1:

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        recursivelyInvert(root);
        return root;
    }
    public void recursivelyInvert(TreeNode root)
    {
        if(root==null)return;
        recursivelyInvert(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        recursivelyInvert(root.right);
        root.right = tmp;
    }
}
