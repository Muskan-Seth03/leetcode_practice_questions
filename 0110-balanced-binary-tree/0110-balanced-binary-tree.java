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
    public int getMaxDepth(TreeNode root)
    {
        if(root == null)
        return 0;
        
        int leftDepth= getMaxDepth(root.left);

        int rightDepth= getMaxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if( root == null)
        return true;

        if(Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) > 1)
        {
            return false;
        }
        
        return isBalanced(root.left)  && isBalanced(root.right);
    }
}
       