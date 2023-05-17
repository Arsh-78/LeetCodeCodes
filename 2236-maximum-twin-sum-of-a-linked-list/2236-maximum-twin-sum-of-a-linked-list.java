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
    public int pairSum(ListNode head) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        int i=0;
        ListNode temp=head;
        int n=0;
        while(temp!=null)
        {
            n=n+2;
            temp=temp.next.next;
        }
        temp = head;
        while(temp!=null)
        {
            if(ans.containsKey(i))
            {
                ans.put(i,ans.get(i)+temp.val);
            }
            else if(ans.containsKey(n-1-i))
            {
                ans.put(n-1-i,ans.get(n-1-i)+temp.val);
            }
            else
            {
                ans.put(i,temp.val);
            }
            i++;
            temp=temp.next;
        }
        int max=0;
        for(Map.Entry<Integer,Integer> e : ans.entrySet())
        {
            if(e.getValue()>=max)
            {
                max=e.getValue();
            }
        }
        return max;
    }
}