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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	 int total = 0;
    
     for(int i=0;i<n;i++)
     {
         total += arr[i];
     }   
     int[][] dp = new int[n][total+1];
     for(int i=0;i<n;i++)
     {
         Arrays.fill(dp[i],Integer.MAX_VALUE);
     }
     return minS(n-1,total,total,arr,n,dp);
   
	    // Your code goes here
	} 
	
	
	public int minS(int i,int curS,int total,int[] nums,int size,int[][] dp)
    {
        
        if(i<0)
        {
            return Math.abs(total-curS*2);
        }
        if(dp[i][curS] != Integer.MAX_VALUE)
        {
            return dp[i][curS];
        }
        int take=minS(i-1,curS-nums[i],total,nums,size-1,dp);
        int ntake = minS(i-1,curS,total,nums,size,dp);
        dp[i][curS] = Math.min(take,ntake);
        
        return Math.min(take,ntake);
    }
}
