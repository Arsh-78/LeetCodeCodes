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
    public int getDecimalValue(ListNode head) {
        
        ListNode temp = head;
        int count=-1;
        int ans=0;

        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
        temp = head;
        while(temp!=null)
        {
            if(temp.val==1 && count!=0)
            {
                ans+= Math.pow(2,count);
            }
            else if(temp.val==1 && count <=0)
            {
                ans=ans+1;
            }
            else
            {
                ans=ans;
            }
            count--;
            temp = temp.next;
        }
        
        return ans;
    }
}