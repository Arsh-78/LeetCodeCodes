class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp =new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],0);
        }
        if(coins.length==1)
        {
            if(amount % coins[0]==0)
            {
                return amount/coins[0];
            }
            return -1;
        }

        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
                dp[0][i]=i/coins[0];
            else
                dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++)
        {
            for(int t = 0;t<=amount;t++)
            {
                    int take = Integer.MAX_VALUE;
                    if(coins[i] <= t)
                    {
                        take = 1+dp[i][t-coins[i]];
                    }
                    int ntake = dp[i-1][t];
                    dp[i][t]=Math.min(ntake,take);
            }
        }
        //int ans=coinCM(n-1,coins,amount,dp);
        //return  ans == 1e9 ? -1 :ans;

        return dp[n-1][amount]==1e9 ? -1 : dp[n-1][amount];
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