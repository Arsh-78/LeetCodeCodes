class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i=0;i<=prices.length;i++)
        {
            Arrays.fill(dp[i][0],0);
            Arrays.fill(dp[i][1],0);
        }
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    
                    int o=0; //two random variables for checking states
                    int t=0;
                    if(j == 1) // permitted to sell but not buy
                    {
                        o = dp[i+1][1][cap];
                        t= prices[i] + dp[i+1][0][cap-1];
                         dp[i][j][cap]=Math.max(o,t);
                    }
                    else
                    {
                        o=dp[i+1][1][cap]-prices[i];
                        t=dp[i+1][0][cap];
                        dp[i][j][cap]=Math.max(o,t);
                    }
                }
                
            }
        }
        return dp[0][0][k];
        
        //return maxm(0,prices,k,0,dp);
    }

    public int maxm(int i,int[] prices,int cap , int trans,int[][][] dp)
    {
        if(cap==0 || i==prices.length)
        {
            return 0;
        }

        if(dp[i][trans][cap] !=-1)
        {
            return dp[i][trans][cap];
        }
        int o=0; //two random variables for checking states
        int t=0;
        if(trans == 1) // permitted to sell but not buy
        {
            o = maxm(i+1,prices,cap,1,dp);
            t= prices[i] + maxm(i+1,prices,cap-1,0,dp);
            return dp[i][trans][cap]=Math.max(o,t);
        }
        o=maxm(i+1,prices,cap,1,dp)-prices[i];
        t=maxm(i+1,prices,cap,0,dp);
        return dp[i][trans][cap]=Math.max(o,t);

    }
}