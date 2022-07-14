// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String S){
     
     String ans = helper(S,1,"");
     return ans;
    
    }
    
    public String helper(String S,int index,String result)
    {
        if(index==S.length())
        {
            result += S.charAt(index-1);
            return result;
        }
        if(S.charAt(index)==S.charAt(index-1))
        {
             return helper(S,index+1,result);
        }
        else
        {
            result += S.charAt(index-1);
            return helper(S,index+1,result);
        }
    }
}