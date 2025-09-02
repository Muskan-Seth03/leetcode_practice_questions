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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null)
        return ans;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag= false;

        while(!q.isEmpty())
        {
            int size= q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode poppedNode= q.poll();
                if(flag)
                {
                    if(poppedNode.left != null)
                    q.offer(poppedNode.left);
                    
                    if(poppedNode.right != null)
                    q.offer(poppedNode.right);
                }
                else
                {
                    if(poppedNode.right != null)
                    q.offer(poppedNode.right);
                    
                    if(poppedNode.left != null)
                    q.offer(poppedNode.left);  
                }
                list.add(poppedNode.val);
            }
            ans.add(list);
            flag= !flag;
        }
        return ans;     
        
    }
}