class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp =new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        if(coins.length==1)
        {
            if(amount % coins[0]==0)
            {
                return amount/coins[0];
            }
            return -1;
        }
        int ans=coinCM(n-1,coins,amount,dp);
        return  ans == 1e9 ? -1 :ans;
    }

    int coinCM(int i ,int[] coins,int amt ,int[][] dp)
    {
        
        if(i==0)
        {
            if(amt%coins[0]==0)
            {
                return amt/coins[0];
            }
            return (int)1e9;
        }
        if(dp[i][amt] != -1)
        {
            return dp[i][amt];
        }
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amt)
        {
            take = 1+coinCM(i,coins,amt-coins[i],dp);
        }
        int ntake = coinCM(i-1,coins,amt,dp);
        dp[i][amt]=Math.min(ntake,take);
        return dp[i][amt];
           
        
    }
}