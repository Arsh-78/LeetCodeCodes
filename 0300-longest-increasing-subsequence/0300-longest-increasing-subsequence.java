class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return LISM(0,nums,-1,dp);
    }
    
    public int LISM(int i,int[] nums,int prev,int[][] dp)
    {
        if(i==nums.length)
        {
            return 0;
        }
        if(dp[i][prev+1]!=-1)
        {
            return dp[i][prev+1];
        }
        int take=0;
        int ntake=0;
        ntake = LISM(i+1,nums,prev,dp);
        if(prev == -1 || nums[i] > nums[prev])
        {
            take = 1 + LISM(i+1,nums,i,dp);
        }
        return dp[i][prev+1]=Math.max(take,ntake);
    }
}