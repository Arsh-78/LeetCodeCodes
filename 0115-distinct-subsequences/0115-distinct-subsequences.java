class Solution {
    static int c=0;
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
        {
            Arrays.fill(dp[i],0);
            dp[i][0]=1;
        }
        
        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=t.length();j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                     dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
                else           
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[s.length()][t.length()];
        
    }
    public int ds(int i,int j,String s,String t,int[][] dp)
    {
        //System.out.println(p);
       if(j==0)
           return 1;
        if(i==0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s.charAt(i-1)==t.charAt(j-1))
        {
            return dp[i][j]=ds(i-1,j,s,t,dp)+ds(i-1,j-1,s,t,dp);
        }
        return dp[i][j]=ds(i-1,j,s,t,dp);
        
    }
}