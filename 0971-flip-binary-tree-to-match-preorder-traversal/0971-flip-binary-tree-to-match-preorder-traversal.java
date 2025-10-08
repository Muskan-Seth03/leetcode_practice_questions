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
// TC: O(N)  SC: O(N)
class Solution {
    List<Integer> res;
    int i;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
       res= new ArrayList<>();
       i=0;

       return dfs(root, voyage)? res: Arrays.asList(-1); 
    }

    private boolean dfs(TreeNode node, int []voyage)
    {
        if( node == null)
        return true;

        if(node.val != voyage[i])
        return false;
        i++;

        if(node.left!= null && node.left.val != voyage[i])
        {
            res.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }
}