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

// TC: O(n)   SC: O(n) 
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res= new ArrayList<>();
        if(root== null)
        return res;
        Queue<TreeNode> q = new  LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size= q.size();
            TreeNode node= null;
            while(size-- >0)
            {
                node= q.poll();
                if(node.left!= null)
                q.offer(node.left);
                if(node.right!= null)
                q.offer(node.right);
            }
            res.add(node.val);     // addd last right most  node
        }
        return res;
    }
}
