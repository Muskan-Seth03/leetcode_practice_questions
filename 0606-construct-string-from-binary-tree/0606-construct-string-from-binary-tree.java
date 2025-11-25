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

 // TC:O(n) SC:(n) in worst case
class Solution {
    public String tree2str(TreeNode root) {
        if(root == null)
        return "";
        String res= Integer.toString(root.val);      
        String left= tree2str(root.left);
        String right= tree2str(root.right);

        if(root.left == null && root.right== null)
            return res;

        if(root.left== null){
            return res + "()" + "(" + right + ")"; 
        }
        if(root.right == null){
            return res + "(" + left + ")"; 
        }

        return res + "(" + left + ")" + "(" + right + ")";
    }
}