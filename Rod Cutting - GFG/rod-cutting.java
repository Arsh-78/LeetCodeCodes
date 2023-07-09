//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int p = price.length;
        int[][] dp = new int[p][n+1];
        for(int i=0;i<p;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        
        return crm(price.length-1,n,price,dp);
    }
    
    public int crm(int i,int l,int[] price,int[][] dp)
    {
        if(i==0)
        {
            if(l%(i+1)==0)
            {
                return l/(i+1) * price[i];
            }
            return 0;
        }
        if(dp[i][l] != -1)
            return dp[i][l];
            
        int ntake = crm(i-1,l,price,dp);
        int take = 0;
        if(i+1<=l)
            take  = price[i] +crm(i,l-i-1,price,dp);
        
        return dp[i][l]=Math.max(take,ntake);
    }
}