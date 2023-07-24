class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp =new int[n];
        int[] c = new int[n];
        Arrays.fill(dp,1);
        int max=0;
        Arrays.fill(c,1);
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j = 0 ; j<i;j++)
            {
                if(nums[i] >nums[j] )
                {
                    if( dp[i]<dp[j]+1)
                    {
                    dp[i] = dp[j]+1;
                    c[i]=c[j];
                    }
                    else if(dp[i]==dp[j]+1)
                    {
                     c[i] = c[i]+c[j];
                    }
                }
                
            }
            if(dp[i]>dp[max])
            {
                max=i;
            }
        }
        
        
        for(int i=0;i<n;i++)
        {
            if(dp[i]==dp[max])
            {
                count += c[i];
            }
        }
        return count;
    }
}