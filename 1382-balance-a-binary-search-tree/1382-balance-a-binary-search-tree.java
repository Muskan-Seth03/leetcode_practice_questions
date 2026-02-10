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
// TC: O(n)  SC: O(log n) + O(n) for ArrayList + O(n) for arr
class Solution {
    // function to build BST from sorted array
    public TreeNode helper(int[] nums, int start, int end)
    {
        if(start > end)
        return null;

        int mid= start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid - 1);
        root.right= helper(nums, mid + 1, end);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n= nums.length;
        return helper(nums, 0, n-1);
    }

    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
        return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
        return root;

        inorder(root, list);
        
        int[] arr = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
                        
        return sortedArrayToBST(arr);
    }
}