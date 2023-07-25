class Solution {
    public int minCost(int n, int[] cuts) {
        
        int c = cuts.length;
        int[] cutn = new int[cuts.length+2];
        cutn[0]=0;
        cutn[cutn.length-1]=n;
        for(int i=1;i<cutn.length-1;i++)
        {
            cutn[i]=cuts[i-1];
        }
        int[][] dp = new int[c+2][c+2];
        for(int i=0;i<c+2;i++)
        {
            Arrays.fill(dp[i],-1);
        }
       // System.out.println(Arrays.toString(cutn));
        Arrays.sort(cutn);
        return helper(1,cuts.length,cutn,dp);
    }
    
    public int helper(int i,int j ,int[] cuts,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int minC = (int)1e9;
        for(int k=i;k<=j;k++)
        {
            int costs = cuts[j+1]-cuts[i-1] + helper(i,k-1,cuts,dp)+helper(k+1,j,cuts,dp);
            
            minC = Math.min(costs,minC);
        }
        return dp[i][j]=minC;
    }
}