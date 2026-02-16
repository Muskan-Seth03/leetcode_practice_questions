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
// TC: O(n)   SC: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        return head;
        
        ListNode prev= null;
        ListNode curr= head;
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev= curr;
            curr= temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // find the middle node 
        ListNode slow= head;
        ListNode fast= head;
        while(fast != null && fast.next != null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        // break the linked list into 2 half and reverse the second half 
        ListNode head2 = null;
        if(fast != null)
        {
            head2= slow.next;
            // slow.next = null;
        }
        else if(fast == null)
        {
            head2= slow;
        }
        ListNode newHead = reverseList(head2);
        ListNode temp2= newHead;

        ListNode temp1 = head;
        while(temp1 != slow && temp2 != null)
        {
            if(temp1.val == temp2.val)
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
            {
                return false;
            }   
        }
        return true;
    }
}