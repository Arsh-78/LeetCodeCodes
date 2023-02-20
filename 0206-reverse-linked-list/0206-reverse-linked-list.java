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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return head;
        }
      ListNode temp = head;
        while(temp.next != null)
        {
            ListNode ex = temp.next;
            
            temp.next=ex.next;
            ex.next = head;
            head=ex;
        }
        return head;
    }
}