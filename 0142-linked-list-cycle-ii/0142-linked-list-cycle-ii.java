/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
     
        HashMap<ListNode,Integer> map = new HashMap();
        int counter =0;
        ListNode temp = head;
        if(head==null)
        {
            return null;
        }
        map.put(temp,1);
        while(temp !=null)
        {
            if(!map.containsKey(temp.next))
            {
                map.put(temp,1);
            }
            else
            {
                return temp.next;
            }
            temp=temp.next;
        }
        return null;
        
    }
}