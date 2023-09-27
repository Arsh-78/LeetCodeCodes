//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            long b = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.power(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod = 1_000_000_007;
    static long power(int a, long b){
        //complete the function here
        long ans =1;
        long c=a;
        //boolean on=false;
    
            
        while(b>0)
        {
            if(b%2!=0)
                ans = (ans*c)%mod;
                
            c = (c*c)%mod;
            //System.out.println(ans);
            b=b/2;
        }
        
        
            
        return ans;
    }
}