//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        int ms=0;
        int s=0;
        int cur=0;
        int e=0;
        
        while(e<n)
        {
            if(arr[e]==1)
            {    
                cur++;
                e++;
            }
            else
            {
                if(m==0)
                {
                    if(arr[s]==1)
                    {    
                        s++;
                        cur--;
                    }
                        
                    else
                    {
                        s++;
                        m++;
                        cur--;
                    }
                }
                else
                {
                    m--;
                    cur++;
                    e++;
                }
            }
            ms=Math.max(ms,cur);
            
        }
        return ms;
    }
}