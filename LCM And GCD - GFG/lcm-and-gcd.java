//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        
        Long ans = 0L;
        if(A>B)
        {
          ans=helperHCF(A,B);
        }
        else
        {
          ans=helperHCF(B,A);
        }
        Long[] fans = new Long[2];
        fans[1] = ans;
        fans[0] = A*B/ans;
        return fans;
    }
    
    static Long helperHCF(Long A , Long B)
    {
        Long divi=A;
        Long divs=B;
        Long ans=divs;
        Long rem = A%B;
        while(rem != 0)
        {
            rem = divi % divs;
            divi=divs;
            ans=divs;
            divs=rem;
        }
        return ans;
    }
    
};