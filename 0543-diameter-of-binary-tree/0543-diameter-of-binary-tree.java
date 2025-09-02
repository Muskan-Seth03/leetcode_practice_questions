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
    int maxDia=0;
    public int findDia(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftSum= findDia(root.left);
        int rightSum= findDia(root.right);
        int currDia=  leftSum + rightSum;
        maxDia=  Math.max(maxDia, currDia);

        return 1 + Math.max(leftSum, rightSum);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return maxDia;
    }
}