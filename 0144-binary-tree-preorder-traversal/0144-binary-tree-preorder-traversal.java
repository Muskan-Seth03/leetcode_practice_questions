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
// Iterative approach
// TC:O(n)  SC:O(n)  in worst case
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { 
        List<Integer> preorder= new ArrayList<>(); 
        Stack<TreeNode> s= new Stack<>();
        if(root == null)
        return preorder;
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode poppedNode= s.pop();
            preorder.add(poppedNode.val);
            if(poppedNode.right!= null)
            s.push(poppedNode.right);
            if(poppedNode.left!= null)
            s.push(poppedNode.left);
        }
        return preorder;       
    }
}