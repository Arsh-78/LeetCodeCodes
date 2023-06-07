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
    public ListNode oddEvenList(ListNode head) {

     if(head==null)
     {
         return head;
     }   
     ListNode ehead=head.next;
     ListNode otrav=head;
     ListNode etrav=ehead;
     while(otrav.next!=null)
     {
         if(otrav.next.next==null)
         {
             etrav.next=null;
             break;
         }
         otrav.next=otrav.next.next;
         otrav=otrav.next;
         etrav.next=otrav.next;
         etrav=etrav.next;
     }
     otrav.next=ehead;
     return head;

    }
}