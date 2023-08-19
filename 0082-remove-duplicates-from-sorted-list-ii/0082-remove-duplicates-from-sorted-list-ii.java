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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode trav = new ListNode(-101,head);
        ListNode dummy = trav;
        ListNode prev = trav;
        if(head==null)
        {
            return null;
        }
        while(trav.next !=null)
        {
            if(trav.val==trav.next.val)
            {
                int temp = trav.val;
                while(trav!=null && trav.val==temp)
                {
                    trav=trav.next;
                }
                prev.next=trav;
                if(trav==null)
                    return dummy.next;
                
            }
            else
            {
                prev=trav;
                trav=trav.next;
            }
        }
        return dummy.next;
    }
}