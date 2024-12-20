package BinaryTree;




// jAKO BITAN DEO JE PROVERITI i sam cvor (mozda je recimo p najveci ancestor za nejga i za, tkao sto mu je direktno otac)

public class LowestCommonAncestor {
    TreeNode sol = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return sol;
    }

    boolean dfs(TreeNode node, int num1, int num2)
    {
        if(node==null)return false;
        boolean self = (node.val == num1 || node.val == num2);
        boolean left = dfs(node.left, num1, num2);
        boolean right = dfs(node.right, num1, num2);
        if((self&&right) || self&&left || left&&right)
        {
            sol = node;
        }
        return self||right||left;
    }
}
