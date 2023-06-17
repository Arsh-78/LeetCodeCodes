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
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int N){
        // code here
        int mask = 1;
        while(mask<=N)
        {
            if((mask&N) ==0)
            {
                return (mask | N);
            }
            else
            {
                mask=mask<<1;
            }
        }
        
        return N;
    }
}