// TC: O(n)  SC: O(w)
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

    public int maxLevelSum(TreeNode root) {
        if(root == null)
        return 1;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int sum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        int count = 0;
        int level = 0;

        while (!q.isEmpty()) {
            count++;
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                sum += node.val;
            }
            if (sum > maxSum) {
                maxSum = sum;
                level = count;
            }
        }
        return level;
    }
}
