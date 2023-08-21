//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findXOR(int l, int r) {
        
        return XOR(r)^XOR(l-1);
        
    }
    
    public static int XOR(int a)
    {
        switch(a%4)
        {
            case 0 : return a;
            case 1: return 1;
            case 2: return a+1;
            case 3 : return 0;
        }
        return -1;
    }
}