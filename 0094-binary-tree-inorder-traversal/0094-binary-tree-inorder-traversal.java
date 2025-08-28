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
 // using iterative approach
 // TC:O(N) SC:O(N)  --- skewed tree 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s= new Stack<>();
        List<Integer> inorder= new ArrayList<>();
        if(root == null)
        return inorder;
        TreeNode node= root;
        while(node!= null || !s.isEmpty())
        {
            if(node != null)
            {
                s.push(node);
                node= node.left;
            }
            else
            { 
                TreeNode poppedNode= s.pop();
                inorder.add(poppedNode.val);
                node= poppedNode.right;
            }
        }
        return inorder;
        
    }
}