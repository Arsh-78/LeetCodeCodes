class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        int n=s.length();
        int[][] dp = new int[n+1][n+1];
        
        sb.append(s);
        String s2 = sb.reverse().toString();
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],0);

        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1) == s2.charAt(j-1))
                {
                     dp[i][j]= 1+ dp[i-1][j-1]; 
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
 
            }
        }
        return n-dp[n][n];
        
    }

    int minInM(int i,int j,String s,String s2,int[][] dp)
    {
        if(i==0 || j==0)
        {
            return 0;
        }
        if(dp[i][j] !=-1)
        {
            return dp[i][j];
        }

        if(s.charAt(i-1) == s2.charAt(j-1))
        {
            return dp[i][j]= 1+ minInM(i-1,j-1,s,s2,dp); 
        }

        return dp[i][j]=Math.max(minInM(i-1,j,s,s2,dp),minInM(i,j-1,s,s2,dp));
    }
}