//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static long topDown(int n) {
        // code here
        long mod =(long) Math.pow(10,9) + 7;
        long[] dp = new long[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=-1;
        }
        
        long ans = fibo(n,dp);
        //System.out.println(ans);
        return ans%mod;
    }
    
    public static long fibo(int n , long[] dp)
    {
        if(n<=1)
            {
            return n;
            }
        if(dp[n]!=-1)
            {
                return dp[n];
            }
            
            
        dp[n]=(fibo(n-1,dp) + fibo(n-2,dp)) %(1000000007) ;
        
        return dp[n];
    }

    static long bottomUp(int n) {
        // code here
        long mod =(long) Math.pow(10,9) + 7;
        long[] dp = new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2 ;i<=n;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        //System.out.println(dp[n]);
        return dp[n]%mod;
    }
}
