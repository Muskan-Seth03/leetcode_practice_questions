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
    int count=0;  //global var
    public int minCameraCover(TreeNode root) {     // have camera (0)
        if(dfs(root)==-1)                          // need (-1)
        count+=1;                                  // don't need (1)

        return count;
    }

    public int dfs(TreeNode node)
    {
        if(node==null)
        return 1;
        
        int lc= dfs(node.left);
        int rc= dfs(node.right);

        if(lc==-1 || rc==-1)//both child need camera , parent has to install camera 
        {
            count++;
            return 0;
        }
        if(lc==0|| rc== 0)  //both child have camera, parent also covered , dont need camera
        {
            return 1;
        }

        //both child dont need camera and dont have camera , the parent need camera 
        return -1;
    }
        
    }
