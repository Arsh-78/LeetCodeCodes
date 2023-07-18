class Solution {
    public int maxProfit(int[] prices) {
        
        
        int n=prices.length;
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
        {
            Arrays.fill(dp[i],-1);
            Arrays.fill(dp[i],-1);
        }
        
        return maxm(0,prices,0,dp);
    
        
        
    }
    
    
    public int maxm(int i,int[] prices, int trans,int[][] dp)
    {
        if(i>=prices.length)
        {
            return 0;
        }

        if(dp[i][trans] !=-1)
        {
            return dp[i][trans];
        }
        int o=0; //two random variables for checking states
        int t=0;
        if(trans == 1) // permitted to sell but not buy
        {
            o = maxm(i+1,prices,1,dp);
            t= prices[i] + maxm(i+2,prices,0,dp);
            return dp[i][trans]=Math.max(o,t);
        }
        o=maxm(i+1,prices,1,dp)-prices[i];
        t=maxm(i+1,prices,0,dp);
        return dp[i][trans]=Math.max(o,t);
    }
}