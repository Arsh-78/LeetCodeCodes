class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int third = Integer.MIN_VALUE;
        int n= nums.length;

        for(int i= n-1;i>=0;i--)
        {
            if(third>nums[i])
                return true;
            
            while(!st.isEmpty() && st.peek()<nums[i])
            {
                third=st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}