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
	        Arrays.fill(dp[i],-1);
	    }
	    return helper(0,arr,sum,dp)%mod; 
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