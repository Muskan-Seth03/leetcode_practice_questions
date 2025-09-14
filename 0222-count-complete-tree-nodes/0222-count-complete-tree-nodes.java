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
 //TC: O(N)  SC: O(N)
import java.util.*;
class Solution {
    int k;
    int level;

    private void bfs(TreeNode target){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(target);

        Set<TreeNode> set= new HashSet<>();
        set.add(target);

        while(!q.isEmpty())
        {
            int n= q.size();
            k= n;
            level++;

            while(n!=0)
            {
                TreeNode node= q.poll();
                if(node.left != null && !set.contains(node.left))
                {
                    q.offer(node.left);
                    set.add(node.left);
                   
                }
                if(node.right!= null && !set.contains(node.right))
                {
                    q.offer(node.right);
                    set.add(node.right);
                  
                }
                n--;
            }
           
        } 
    }
   
    public int countNodes(TreeNode root) {
        level=0;

        if(root == null)
        return 0;

        // if only one node present==> leaf node 
        if(root.left == null && root.right == null)
        return 1;

        bfs(root);
        int count=0;
        // 2^0 + 2^1+ 2^2+ ...
        count = (1 << (level - 1)) - 1;
        return count + k;
        
    }
}