//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M,N,X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long noOfWays(int M , int N , int X) {
        long[][] dp = new long[N+1][X+1];
        for(int i=0;i<=N;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        // code here
        return helper(N,M,X,dp);
    }
    
    static long helper(int d,int c,int s,long[][] dp)
    {
        if(d==0 && s==0)
        {
            return 1;
        }
        else if(d==0 || s<0)
        {
            return 0;
        }
        if(dp[d][s] != -1)
            return dp[d][s];
            
        long ways=0;
        for(int i=1;i<=c;i++)
        {
            ways+=helper(d-1,c,s-i,dp);
        }
        
        return dp[d][s]=ways;
    }
};