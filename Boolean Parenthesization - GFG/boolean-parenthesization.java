//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    static int mod = 1003;
    static int countWays(int N, String S){
        // code here
        long[][][] dp= new long[N][N][2];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                Arrays.fill(dp[i][j],-1);
        }
        return (int)evalw(0,N-1,S,1,dp);
    }
    
    public static long evalw(int i,int j, String s,int isTrue,long[][][] dp)
    {
        if(i>j)
            return 0;
            
        if(i==j)
        {
            if(isTrue==1)
                return s.charAt(i)=='T' ? 1 :0; 
            else
                return s.charAt(i)=='F' ? 1:0;
        }
        if(dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
              
        long ways =0;  
        for(int k=i+1;k<=j-1;k+=2)
        {
            long lT =evalw(i,k-1,s,1,dp)%1003;
            long lF=evalw(i,k-1,s,0,dp)%1003;
            long rT = evalw(k+1,j,s,1,dp)%1003;
            long rF=evalw(k+1,j,s,0,dp)%1003;
            
            if (s.charAt(k) == '&') {
            if (isTrue==1) ways = (ways + (lT * rT) % mod) % mod;
            else ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
        }
        else if (s.charAt(k) == '|') {
            if (isTrue==1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT * rT) % mod) % mod;
            else ways = (ways + (lF * rF) % mod) % mod;
        }
        else {
            if (isTrue==1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
            else ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
        }
           
        }
        return dp[i][j][isTrue]=ways%1003;
    }
}