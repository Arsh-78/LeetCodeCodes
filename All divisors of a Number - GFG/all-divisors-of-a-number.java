//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
        ArrayList<Integer>  l= new ArrayList<>();
        
        System.out.print(1+" ");
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                if(n/i!=i)
                {
                    l.add(n/i);
                }
                System.out.print(i+" ");
            }
        }
        
        for(int i=l.size()-1;i>=0;i--)
        {
            System.out.print(l.get(i)+" ");
        }
        if(n!=1)
            System.out.print(n);
    }
    
}
