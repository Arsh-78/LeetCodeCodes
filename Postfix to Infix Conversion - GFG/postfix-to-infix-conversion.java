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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        
        String ans;
        Stack<String> st = new Stack<>();
        int i=0;
        while(i<exp.length())
        {
            String temp = "";
            if(isOp(exp.charAt(i)))
            {
                String fexp=st.pop();
                temp+= "("+st.pop()+exp.charAt(i)+fexp+")";
                st.push(temp);
            }
            else
            {
                temp += exp.charAt(i);
                st.push(temp);
            }
            i++;
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
