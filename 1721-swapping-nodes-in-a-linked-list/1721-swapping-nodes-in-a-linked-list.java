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
    public ListNode swapNodes(ListNode head, int k) {
     
        int fp=1;
        int sp=0;
        ListNode fn=head;
        ListNode fnp=null,bnp=null;
        ListNode bn=head;
        ListNode temp=head;
        while(fp<k)
        {
            if(fp==k-1)
            {
                fnp=temp;
            }
            temp=temp.next;
            fp++;
        }
        fn =temp;
        while(temp!=null)
        {
            temp=temp.next;
            sp++;
        }
        int n=fp+sp-1;
        if(fp==sp)
        {
            return head;
        }
        fp=1;
        temp = head;
        while(fp<sp)
        {
            if(fp==sp-1)
            {
                bnp=temp;
            }
            temp=temp.next;
            fp++;
        }
        bn=temp;
        int t=fn.val;
        fn.val=bn.val;
        bn.val=t;
        return head;
        
    }
}