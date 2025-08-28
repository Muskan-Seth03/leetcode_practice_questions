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
 // TC: O(N)  SC:O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null)
        return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size= q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode poppedNode= q.poll();
                if(poppedNode.left != null)
                q.offer(poppedNode.left);
                
                if(poppedNode.right != null)
                q.offer(poppedNode.right);
                
                list.add(poppedNode.val);
            }
            ans.add(list);
        }
        return ans;     
    }
}