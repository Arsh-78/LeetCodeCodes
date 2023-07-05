//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean [][] dp = new boolean[N][sum+1];
    
        for(int i=0;i<N;i++)
        {
            dp[i][0]=true;
        }
        if(sum>=arr[0])
            dp[0][arr[0]]=true;
        
        for(int i= 1; i<N;i++)
        {
            for(int target=0;target<=sum;target++)
            {
                
        boolean take = false;
        if(target>=arr[i])
            take=dp[i-1][target-arr[i]];
            
        boolean ntake = dp[i-1][target];
        
         dp[i][target]= take | ntake;
        
                
            }
        }
        return dp[N-1][sum];
        
        
    }
    
    static Boolean findT(int idx, int arr[], int target,int[][] dp)
    {
        
        if(idx<0 || target<0)
        {
            return false;
        }
        if(target==0)
        {
            return true;
        }
        if(idx==0 && arr[idx]==target)
        {
            return true;
        }
        if(dp[idx][target] != -1)
        {
            if(dp[idx][target]==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        boolean take = false;
        if(target>=arr[idx])
            take=findT(idx-1,arr,target-arr[idx],dp);
            
        boolean ntake = findT(idx-1,arr,target,dp);
        
        dp[idx][target]= take | ntake == true ? 1 :0;
        
        return take|ntake;
    }
    
    
}