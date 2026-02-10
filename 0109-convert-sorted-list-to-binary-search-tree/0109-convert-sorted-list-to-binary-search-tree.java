/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
// TC: O(n)  SC: O(log n) + O(n) + O(n)
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

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        return null;

        List<Integer> list= new ArrayList<>();

        while(head.next != null)
        {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        
        int[] arr= list.stream()
                        .mapToInt(Integer :: intValue)
                        .toArray();

        return sortedArrayToBST(arr);
    }
}