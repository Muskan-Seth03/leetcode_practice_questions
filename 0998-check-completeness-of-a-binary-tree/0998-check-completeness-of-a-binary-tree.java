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
class Solution {
    public int countNodes(TreeNode node)
    {
        if(node ==null)
        return 0;
        
        return 1+ countNodes(node.left) + countNodes(node.right);
    } 

    public boolean dfs(TreeNode node, int i, int n)
    {
        if(node== null)
        return true;
        if(i>=n)
        return false;

        return dfs(node.left, 2*i + 1, n) && dfs(node.right, 2*i+2, n);
    }

    public boolean isCompleteTree(TreeNode root) {
        int n= countNodes(root);
        return dfs(root, 0, n);
    }
}
