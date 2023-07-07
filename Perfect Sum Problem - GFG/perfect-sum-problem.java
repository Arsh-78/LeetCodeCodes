//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int mod = 1000000007;
	    int[][] dp = new int[n][sum+1];
	    

	    for(int i=0;i<n;i++)
	    {
	        //Arrays.fill(dp[i],-1); memoization
	        
	        Arrays.fill(dp[i],-0);
 	    }
	    if(arr[n-1]==0)
	    {
	        dp[n-1][0]=2;
	    }
	    else
	    {
	        dp[n-1][0]=1;
	        dp[n-1][arr[n-1]]=1;
	    }
	    
	    for(int i=n-2;i>=0;i--)
	    {
	        for(int t=0;t<=sum;t++)
	        {
	       int take=0;
	    if(t>=arr[i])
	        take = dp[i+1][t-arr[i]]%mod;
	    int ntake = dp[i+1][t]%mod;
	    dp[i][t]=(take+ntake)%mod;
	    
	        }
	    }
	    
	    return dp[0][sum]; 
	}
	
	public int helper(int i ,int[] arr,int curSum,int[][] dp)
	{
	    int mod = 1000000007;
	    
	    
	    
	    if(i==arr.length-1)
	    {
	        if(curSum==0)
	        {
	            if(arr[i]==0)
	            {
	                return 2;
	            }
	            else
	            {
	                return 1;
	            }
	        }
	        else
	        {
	            if(arr[i]==curSum)
	                return 1;
	           
	           return 0;
	        }
	        
	    }

	    if(dp[i][curSum] !=-1)
	   {
	       return dp[i][curSum];
	   }
	    int take=0;
	    if(curSum>=arr[i])
	        take = helper(i+1,arr,curSum-arr[i],dp)%mod;
	    int ntake = helper(i+1,arr,curSum,dp)%mod;
	    dp[i][curSum]=(take+ntake)%mod;
	    return (take+ntake)%mod;
	}
}