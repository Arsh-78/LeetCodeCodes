class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        int n=s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],0);
        }
        sb.append(s);
        String s2 = sb.reverse().toString();

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]= 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[n][n];

        //return lpsM(n,n,s,s2);
    }

    int lpsM(int i,int j,String s,String s2)
    {
        if(i==0 || j==0)
        {
            return 0;
        }

        if(s.charAt(i-1)==s2.charAt(j-1))
        {
            return 1 + lpsM(i-1,j-1,s,s2);
        }

        return Math.max(lpsM(i-1,j,s,s2),lpsM(i,j-1,s,s2));
    }
}