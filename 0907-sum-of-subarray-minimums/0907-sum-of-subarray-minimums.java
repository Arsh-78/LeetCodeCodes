class Solution {
    int mod = 1000_000_007;
    public int sumSubarrayMins(int[] arr) {
     
        int n=arr.length; 
        int[] left = new int[n];
        int[] right =new int[n];
        
        Stack<Integer> st =  new Stack<>();
        right[n-1]=n;
        st.push(n-1);
        int j=n-2;
        while(j>=0)
        {
            if(arr[j] < arr[j+1])
            {
                while(!st.isEmpty() && arr[st.peek()]>arr[j])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    right[j]=n;
                }
                else
                    right[j] = st.peek();
                st.push(j);
            }
            else
            {
                if(st.isEmpty())
                    right[j]=n;
                else
                    right[j]=st.peek();
                
                st.push(j);
            }
            j--;
        }
        left[0]=-1;
        j=1;
        
        while(!st.isEmpty())
            st.pop();
        st.push(0);
        while(j<=n-1)
        {
            if(arr[j-1] >= arr[j])
            {
                while(!st.isEmpty() && arr[st.peek()]>=arr[j])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    left[j]=-1;
                }
                else
                    left[j] = st.peek();
                st.push(j);
            }
            else
            {
                if(st.isEmpty())
                    left[j]=-1;
                else
                    left[j]=st.peek();
                
                st.push(j);
            }
            j++;
        }
        long ans=0;
        int ls=0;
        int rs=0;
        for(int i=0;i<n;i++)
        {
            ls= i-left[i];
            rs = right[i]-i;
            long ts = (ls*rs)%mod;
            ans=(ans+(arr[i]*ts)%mod)%mod;
        }
        
        
        //System.out.println(Arrays.toString(left) + "   "+Arrays.toString(right));
        return (int)(ans%mod);
    }
}