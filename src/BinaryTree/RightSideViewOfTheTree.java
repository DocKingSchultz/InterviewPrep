package BinaryTree;

//Binary Tree Right Side View
//You are given the root of a binary tree.
//Return only the values of the nodes that are visible from the right side of the tree,
//ordered from top to bottom.

//Input: root = [1,2,3]
//
//Output: [1,3]

//Input: root = [1,2,3,4,5,6,7]
//
//Output: [1,3,7]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Level Order just print the last element :
public class RightSideViewOfTheTree {
    public List<Integer> rightSideView(TreeNode root) {
        // Prepare :
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;

        queue.add(root);
        int size;

        while(!queue.isEmpty())
        {
            size = queue.size();
            TreeNode currNode = null;
            while(size!=0)
            {
                currNode = queue.poll();
                size--;
                if(currNode.left!=null)queue.add(currNode.left);
                if(currNode.right!=null)queue.add(currNode.right);
            }
            res.add(currNode.val);
        }
        return res;
    }
}
