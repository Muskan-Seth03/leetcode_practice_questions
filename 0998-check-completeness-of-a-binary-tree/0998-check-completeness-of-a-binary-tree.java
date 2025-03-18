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
    public boolean isCompleteTree(TreeNode root) {
        if(root== null)
        return true;

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        boolean flag= false;  // to detect if the null node is encountered

        while(!q.isEmpty())
        {
            TreeNode x= q.poll();
            if(x== null)
            {
                flag=true;
            }
            else
            {
                if(flag==true)
                return false;

                else
                {
                    q.offer(x.left);
                    q.offer(x.right);
                }
            }
        }
        return true;
    }
} 
