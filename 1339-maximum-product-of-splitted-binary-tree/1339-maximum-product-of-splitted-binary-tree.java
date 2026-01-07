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
    int totalTreeSum;
    long maxProduct;

    public int totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        int leftSum = find(root.left);
        int rightSum = find(root.right);
        int subtreeSum = root.val + leftSum + rightSum;
        // Calculate product for this possible split
        long product = (long) subtreeSum * (totalTreeSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        totalTreeSum = totalSum(root);
        maxProduct = 0;
        find(root);
        return (int)(maxProduct % MOD);
    }
}