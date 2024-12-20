package BinaryTree;

//Count Good Nodes in Binary Tree
//Within a binary tree, a node x is considered good if the path from the root of the tree
//to the node x contains no nodes with a value greater than the value of node x
//
//Given the root of a binary tree root, return the number
//of good nodes within the tree

// Ukratko :  resenje : svi cvorovi, koji nemaju predaka da je veci od njih


//Input: root = [2,1,1,3,null,1,5]
//
//Output: 3

//Input: root = [1,2,-1,3,4]
//
//Output: 4

import java.util.LinkedList;

public class CountGoodNodes {
    int solution = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return solution;
    }
    void dfs(TreeNode node, int max)
    {
        if(node==null)return;
        if(node.val>=max)solution++;
        int localMax = Math.max(max, node.val);
        dfs(node.left, localMax);
        dfs(node.right, localMax);
    }
}
