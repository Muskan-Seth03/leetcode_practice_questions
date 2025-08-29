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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder= new ArrayList<>();
        if(root == null)
        return postorder;

        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();

        s1.push(root);
        while(!s1.isEmpty())
        {
            TreeNode poppedNode= s1.pop();

            if(poppedNode.left != null)
            s1.push(poppedNode.left);
            
            if(poppedNode.right!= null)
            s1.push(poppedNode.right);

            s2.push(poppedNode);
        }
        while(s1.isEmpty() && !s2.isEmpty())
        {
            postorder.add(s2.pop().val);
        }
        return postorder;        
    }
}