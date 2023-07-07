//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int arr[]){
        // Code here
         int mod = 1000000007;
       
        int total=0;
        for(int i=0;i<n;i++)
        {
            total += arr[i];
        }
        int[][] dp = new int[n][total+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        //dp[n][(total+d)/2]=1;
        /*
        for(int i=n-1 ; i>0;i--)
        {
            for(int target=0;target<=total;target++)
            {
                    int take=dp[i+1][target];
                    int ntake=0;
                    if(2*target-total >=d )
                    {
                        ntake=dp[i+1][target-arr[i-1]];
                    }
            
                     dp[i][target]=(take+ntake)%mod;
            }
        }
        return dp[0][total];
        */
        //memoization
        return countPM(0,total,arr,total,d,dp);
        
    }
    
    int countPM(int i,int curS,int[] arr,int total,int d,int[][] dp)
    {
        int mod = 1000000007;
        if(i==arr.length)
        {
            if(2*curS - total==d)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[i][curS]!=-1)
        {
            return dp[i][curS];
        }
        
        int take=countPM(i+1,curS,arr,total,d,dp);
        int ntake=0;
        if(2*curS-total >=d)
        {
            ntake=countPM(i+1,curS-arr[i],arr,total,d,dp);
        }
            
        dp[i][curS]=(take+ntake)%mod;
        return dp[i][curS];
    }
}