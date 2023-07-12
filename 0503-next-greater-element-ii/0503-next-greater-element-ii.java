class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st = new Stack<>();
        int[] cir = new int[2*n];
        int[] nge2=new int[2*n];
        int[] nge1=new int[n];
        for(int i=0;i<2*n;i++)
        {
            cir[i] = nums[i%n];
        }
        int j=2*n-1;
        nge2[j]=-1;
        st.push(cir[j]);
        j--;
        while(j>=0)
        {
            if(cir[j]>=cir[j+1])
            {
                while(!st.isEmpty() && st.peek()<=cir[j])
                {
                    st.pop();
                }
            }
            if(st.isEmpty())
                nge2[j]=-1;
            else
                nge2[j]=st.peek();
            st.push(cir[j]);
            j--;
        }
        for(int i=0;i<n;i++)
        {
            nge1[i]=nge2[i];
        }
        return nge1;
    }
}