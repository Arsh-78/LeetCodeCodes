class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        //int[][] dp = new int[n+1][2];

        // for(int i=0;i<n;i++)
        // {
        //     Arrays.fill(dp[i],0);
        // }

        int[] ahead = new int[2];
        int[] cur = new int[2];

        Arrays.fill(ahead,0);
        for(int i=n-1;i>=0;i--)
        {
            for(int trans=0;trans<=1;trans++)
            {
                int sell=0;
                int unS=0;
                if(trans==1) // only sell no buy
                {
                    sell = prices[i]+ahead[0]-fee;
                    unS = ahead[1];
                     cur[trans]=Math.max(sell,unS);
                }
                else
                {
                     sell = ahead[1]-prices[i];
                     unS = ahead[0];
                    cur[trans]=Math.max(sell,unS);
                }

           }
           ahead=cur;
        }
        return ahead[0];
        //return mpM(0,prices,fee,0,dp);
    }


    public int mpM(int i,int[] prices,int fee, int trans,int[][] dp)
    {
        if(i==prices.length)
        {
            return 0;
        }
        if(dp[i][trans] != -1)
        {
            return dp[i][trans];
        }
        int sell=0;
        int unS=0;
        if(trans==1) // only sell no buy
        {
            sell = prices[i]+mpM(i+1,prices,fee,0,dp)-fee;
            unS = mpM(i+1,prices,fee,1,dp);
            return dp[i][trans]=Math.max(sell,unS);
        }

        sell = mpM(i+1,prices,fee,1,dp)-prices[i];
        unS = mpM(i+1,prices,fee,0,dp);
        return dp[i][trans]=Math.max(sell,unS);

    }
}