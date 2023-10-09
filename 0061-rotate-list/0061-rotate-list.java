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
    public ListNode rotateRight(ListNode head, int k) {
     int tn =0;
     if(head==null)
        return head;

     ListNode trav = head;
     while(trav.next!=null)
     {
        trav=trav.next;
        tn++; 
     }
     tn++;
     k=k%tn;
     trav.next = head;
     tn=tn-k-1;

     trav=head;
     while(tn>0)
     {
     trav=trav.next;
     tn--;
     }
     ListNode ans = trav.next;
     trav.next = null;
    return ans;
    }
    
}