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
// TC: O(n) for hashmap + O(n) for processing each node once in helper + O(1) for lookup in map
// SC: O(n) for hashmap + O(n) for recursion stack   
class Solution {
    private int ind;
    private Map<Integer, Integer> inorderMap= new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ind= postorder.length - 1;
        for(int i=0; i< inorder.length; i++)
        {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int []postorder, int start, int end)
    {
        if(start > end)
        return null;

        int rootVal= postorder[ind];
        ind--;

        TreeNode root= new TreeNode(rootVal);

        root.right= helper(postorder, inorderMap.get(rootVal) + 1, end);
        
        root.left= helper(postorder, start, inorderMap.get(rootVal) - 1);

        return root;
    }
}