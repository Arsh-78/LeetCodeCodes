class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++)
        {
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }

        return maxm(0,prices,k,0,dp);
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