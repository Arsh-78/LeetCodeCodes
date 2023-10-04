//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String s)
    
    {
        // code here
        int mod= 1_000_000_007;
        int[] dp = new int[s.length()+1];
        int n=s.length();
        Arrays.fill(dp,-1);
        dp[n]=1;
        
        for(int i=n-1;i>=0;i--)
        {
            long res=0;
        if(s.charAt(i)!= '0')
        {
            res+= (dp[i+1]);
        }
        if(i<s.length()-1 &&(s.charAt(i)=='1' || (s.charAt(i)=='2'&& s.charAt(i+1)<'7')))
            res+= dp[i+2]; 

            dp[i]=(int)(res%mod);   
        }
        return dp[0];
    }
}