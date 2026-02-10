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
 // TC: O(n)
 // SC: O(n) for skewed tree and O(log n) for balanced tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;

        int leftDepth= maxDepth(root.left); 
        int rightDepth= maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth); 
    }
}