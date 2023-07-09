//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lcSM(n,m,S1,S2,dp);
    }
    int lcSM(int i,int j,String s1,String s2,int[][] dp)
    {
        if(i==0 || j==0)
        {
            return 0;
        }
        
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        
        
            int c=0;
            int f=i-1;
            int g=j-1;
            while(f>=0 && g>=0){
                if(s1.charAt(f)==s2.charAt(g))
                {
                    c++;
                    f--;
                    g--;
                }
                else
                {
                    break;
                }
            }
            return dp[i][j]=Math.max(c,Math.max(lcSM(i-1,j,s1,s2,dp),lcSM(i,j-1,s1,s2,dp)));
        
        
        
        
    }
}