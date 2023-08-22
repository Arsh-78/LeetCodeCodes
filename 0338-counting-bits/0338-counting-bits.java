class Solution {
    public int[] countBits(int n) {
     
        int[] ans = new int[n+1];
        if(n==0)
            return new int[]{0};
        if(n==1)
            return new int[]{0,1};
        ans[0] = 0;
        ans[1]=1;
        ans[2]=1;
        
        for(int i=3;i<=n;i++)
        {
            if(i%2==0)
            {
                ans[i]=ans[i/2];
            }
            else
            {
                ans[i] = ans[(i-1)/2]+1;
            }
        }
        
        return ans;
    }
}