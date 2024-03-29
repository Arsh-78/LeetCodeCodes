//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class gfg
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String s[] = read.readLine().trim().split("\\s+");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            
            int arr[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(st[i]);
            }
            
            Solution obj = new Solution();
            
            System.out.println(obj.searchInSorted(arr, n, k));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int searchInSorted(int nums[], int N, int K)
    {
        int s=0;
        int e=N-1;
        int m=s+(e-s)/2;
        while(s<=e)
        {
            m=s+(e-s)/2;
            if(nums[m]==K)
            {
                return 1;
            }
            if(nums[m]<K)
            {
                s=m+1;
            }
            else
            {
                e=m-1;
            }
        }
        return -1;
    }
}