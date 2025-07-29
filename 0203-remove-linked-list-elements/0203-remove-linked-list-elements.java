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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // LL is null or LL contains 1 el which we have to delete 
        if(head==null || head.next==null  && head.val == val)
        return null;

        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode prev= dummy;
        ListNode temp= head;
       
        while(temp != null)
        {
            if(temp.val== val)
            {
                prev.next= temp.next;
                temp= prev.next;
            }
            else
            {
            prev= temp;
            temp= temp.next;
            }
        }
        return dummy.next;
    }
}