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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int[] dp = new int[n];
        int[] dps = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dps,1);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0 ; j<i;j++)
            {
                if(nums[j] < nums[i] && dp[i]<dp[j]+1)
                {
                    dp[i] = 1+dp[j];
                }
            }
            
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+1; j<n;j++)
            {
                if(nums[j] < nums[i] && dps[i]<dps[j]+1)
                {
                    dps[i] = 1+dps[j];
                }
            }
            
            if(dp[i] + dps[i] > ans)
            {
                ans=dp[i]+dps[i];
            }
        }
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(dps));
        
        return ans-1;
        
    }
}