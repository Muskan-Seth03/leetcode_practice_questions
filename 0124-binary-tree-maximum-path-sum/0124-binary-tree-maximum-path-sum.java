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

// TC: O(n)  SC: O(log n)
class Solution {
    int maxPathSum= Integer.MIN_VALUE;
    public int findPathSum(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftSum= Math.max(0, findPathSum(root.left));
        int rightSum= Math.max(0, findPathSum(root.right));
        int currPathSum=  leftSum + rightSum + root.val;
        maxPathSum=  Math.max(maxPathSum, currPathSum);
       
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return  maxPathSum;        
    }
}