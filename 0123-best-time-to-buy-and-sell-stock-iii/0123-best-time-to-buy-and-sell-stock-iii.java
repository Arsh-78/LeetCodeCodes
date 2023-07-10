class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        return maxPm(0,1,2,prices,dp);
    }

    int maxPm(int i ,int buy,int cap ,int[] prices,int[][][] dp)
    {
        if(cap==0)
        {
            return 0;
        }
        if(i==prices.length)
        {
            return 0;
        }
        if(dp[i][buy][cap] !=-1)
        {
            return dp[i][buy][cap];
        }

        if(buy==1)
        {
            return dp[i][1][cap]=Math.max(
                maxPm(i+1,0,cap,prices,dp)-prices[i],
                maxPm(i+1,1,cap,prices,dp)
            );
        }
        else
        {
            return dp[i][0][cap]=Math.max(
                maxPm(i+1,1,cap-1,prices,dp) + prices[i],
                maxPm(i+1,0,cap,prices,dp)
            );
        }
    }
}