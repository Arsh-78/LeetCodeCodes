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
        ListNode trav = new ListNode(0,head);
        ListNode dummy = trav;
        while(trav.next!=null)
        {
            if(trav.next.val==val)
                trav.next = trav.next.next;
            else
                trav=trav.next;
        }
        return dummy.next;
    }
}