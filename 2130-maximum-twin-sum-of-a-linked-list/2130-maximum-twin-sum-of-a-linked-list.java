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
// Approach 3 : reversing the half of the LL
class Solution {
    public int pairSum(ListNode head) {

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow points to middle node 
        ListNode mid = null;
        mid = slow;

        ListNode nextNode = null;
        prev = null;

        // reverse the Linked List
        while(mid != null)
        {
            nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }

        //Reversing Part
        ListNode curr = head;
        int result = 0;
        while(prev != null) {
            result = Math.max(result, curr.val + prev.val);
            curr = curr.next;
            prev = prev.next;
        }
        return result;
    }
}