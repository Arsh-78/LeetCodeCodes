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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();

        ListNode slow = head;
        while(slow != null)
        {
            st.push(slow.val);
            slow=slow.next;
        }
        slow = head;
        while(!st.isEmpty())
        {
            if(st.pop()!=slow.val)
            {
                return false;
            }
            slow=slow.next;
        }
        return true;
    }
}