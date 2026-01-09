/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 1 pass solution
// TC: O(n) SC: O(maxD)
class Pair{
    TreeNode node;
    int d;
    Pair(TreeNode node, int d){
        this.node= node;
        this.d= d;
    }
} 
class Solution {
    public Pair dfs(TreeNode root)
    {
        if(root == null)
        return new Pair(root, 0);

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        if(l.d == r.d)
        {
            return new Pair(root, l.d + 1);
        }
        else if(l.d > r.d) 
        {
            return new Pair(l.node, l.d + 1);
        }
        else
        {
            return new Pair(r.node, r.d + 1);
        }
    }
  
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
}