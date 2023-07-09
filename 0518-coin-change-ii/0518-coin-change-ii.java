class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp =new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],0);
        }
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            {
                dp[0][i]=1;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int amt=0;amt<=amount;amt++)
            {
                int ntake= dp[i-1][amt];
                int take =0;
                if(amt>=coins[i])
                {
                    take= dp[i][amt-coins[i]];
                }
 
               dp[i][amt]=take+ntake;

            }
        }
        return dp[n-1][amount];
    }

    public int changeM(int i,int amt,int[] coins,int[][] dp) 
    {
        if(i==0)
        {
            if(amt%coins[0]==0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[i][amt] !=-1)
        {
            return dp[i][amt];
        }
        int ntake= changeM(i-1,amt,coins,dp);
        int take =0;
        if(amt>=coins[i])
        {
            take= changeM(i,amt-coins[i],coins,dp);
        }

        return dp[i][amt]=take+ntake;
        
    }
}