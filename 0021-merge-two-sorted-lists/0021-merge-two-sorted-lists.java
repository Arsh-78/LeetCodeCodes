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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     
        ListNode cp = new ListNode(-1); 
        ListNode fh = cp;
        while(list1 != null && list2!=null)
        {
            if(list1.val <= list2.val)
            {
                cp.next=list1;
                list1=list1.next;
                
                
            }
            else
            {
                cp.next=list2;
                list2=list2.next;
            }
            
            cp=cp.next;
        }
        
        while(list1 !=null)
        {
            cp.next=list1;
            list1=list1.next;
            cp=cp.next;
        }
        
        while(list2 !=null)
        {
            cp.next=list2;
            list2=list2.next;
            cp=cp.next;
        }
        
        return fh.next;
        
    }
    
    
}