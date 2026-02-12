/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// slow and fast pointer approach
// TC: O(n)  SC: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        return null;

        ListNode slow= head;
        ListNode fast= head;
        boolean flag = false;
        while(fast != null && fast.next != null)
        {
            slow= slow.next;
            fast= fast.next.next;

            if(slow == fast)
            {
                flag = true;
                break;
            }
        }
        if(!flag) return null;
        fast = head;
        while(flag && fast != slow)
        {
            slow= slow.next;
            fast= fast.next;
        }
        return slow;
    }
}