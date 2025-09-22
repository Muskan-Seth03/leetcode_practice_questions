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
    private int ind= 0;
    private Map<Integer, Integer> inorderMap= new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i< inorder.length; i++)
        {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int []preorder, int start, int end)
    {
        if(start > end)
        return null;

        int rootVal= preorder[ind];
        ind++;

        TreeNode root= new TreeNode(rootVal);

        root.left= helper(preorder, start, inorderMap.get(rootVal) - 1);

        root.right= helper(preorder, inorderMap.get(rootVal) + 1, end);

        return root;
    }
}