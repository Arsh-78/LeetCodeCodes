//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        int i = pre_exp.length()-1;
        String ans;
        while(i>-1)
        {
            String temp = "" ;
            if(isOp(pre_exp.charAt(i)))
            {
                temp += "("+st.pop() + pre_exp.charAt(i) +st.pop() + ")";
                st.push(temp);
            }
            else
            {
                temp += pre_exp.charAt(i);
                st.push(temp);
                
            }
            
            i--;
        }
         ans = st.pop();
        
        return ans;
    }
    
    
    static boolean isOp(char c)
    {
        if(c!='+' && c!='-' && c!='*' && c!='/' && c!='^')
        {
            return false;
        }
        
        return true;
    }
}
