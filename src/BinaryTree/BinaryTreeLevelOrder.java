package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    List<List<Integer>> levels = new ArrayList<>();
    int level = 0;
    int size = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return levels;
        queue.add(root);
        while(!queue.isEmpty())
        {
            ArrayList<Integer> currLevel = new ArrayList<>();
            size = queue.size();
            while(size!=0)
            {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
            levels.add(currLevel);
        }
        return levels;
    }
}
