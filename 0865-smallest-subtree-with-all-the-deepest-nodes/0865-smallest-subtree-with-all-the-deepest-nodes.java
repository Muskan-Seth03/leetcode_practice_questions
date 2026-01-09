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
// 2 pass solution
// TC: O(n) SC: O(maxD)
class Solution {
    int maxD;
    Map<Integer, Integer> map;

    // creating hashmap with all node.val and its level
    public void depth(TreeNode root, int d) {
        if (root == null) return;

        maxD = Math.max(maxD, d);
        map.put(root.val, d);

        depth(root.left, d + 1);
        depth(root.right, d + 1);
    }

    public TreeNode LCA(TreeNode root) {
        if (root == null || map.get(root.val) == maxD) return root;

        TreeNode left = LCA(root.left);
        TreeNode right = LCA(root.right);

        if (left != null && right != null) return root;

        if (left != null) return left; else return right;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxD = 0;
        map = new HashMap<>();

        if (root == null) return null;

        depth(root, 0);

        return LCA(root);
    }
}
