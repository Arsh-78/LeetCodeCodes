class Solution {
    public int maxProfit(int[] prices) {
        int[][] after = new int[2][3];
        int[][] cur = new int[2][3];
        
       for(int i=0;i<2;i++)
       {
           Arrays.fill(after[i],0);
           Arrays.fill(cur[i],0);
       }
        
        for(int i=prices.length-1;i>=0;i--)
        {

            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
                {
                    if(buy==1)
                    {
                        cur[buy][cap]=Math.max(
                        after[0][cap]-prices[i],
                        after[1][cap] );
                     }
                    else
                    {
                        cur[buy][cap]=Math.max(
                        after[1][cap-1] + prices[i],
                        after[0][cap]);
                    }
                    
                }
            }
            after=cur;
        }
        return after[1][2];
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