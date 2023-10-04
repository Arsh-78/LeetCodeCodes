class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(0,s,dp);
    }

    public int helper(int i ,String s,int[] dp)
    {
        if(i>=s.length())
        {
            return 1;
        }
        if(dp[i] != -1)
        {
            return dp[i];
        }
        int res =0;
        if(s.charAt(i)!= '0')
        {
            res+= helper(i+1,s,dp);
        }
        if(i<s.length()-1 &&(s.charAt(i)=='1' || (s.charAt(i)=='2'&& s.charAt(i+1)<'7')))
            res+= helper(i+2,s,dp);

        return dp[i]=res;
    }
}