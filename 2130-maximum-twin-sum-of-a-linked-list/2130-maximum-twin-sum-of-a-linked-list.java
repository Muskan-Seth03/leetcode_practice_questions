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
// Approach 1 : Using stack
class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> s = new Stack<>();
        
        ListNode curr = head;
        int n = 0;
        // no of nodes in the list
        while (curr != null) {
            n++;
            s.push(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        int res = 0;
        int maxEl = 0;

        for(int i=0; i<n/2; i++)
        {
            maxEl = Math.max(curr.val + s.peek(), maxEl);
            curr = curr.next;
            s.pop();
        }
        return maxEl;   
    }
}