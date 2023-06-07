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
    public ListNode deleteMiddle(ListNode head) {

     ListNode fp=head;
     ListNode sp=head;
     ListNode ps =sp;
     if(head==null)
     {
         return head;
     }
     if(head.next==null)
     {
         return null;
     }
     while(fp.next!=null)
     {
         if(fp.next.next==null)
         {
             sp.next=sp.next.next;
             return head;
         }
         fp=fp.next.next;
         ps=sp;
         sp=sp.next;

     }
     if(ps.next!=null)   
        ps.next=ps.next.next;
     return head;
    }
}