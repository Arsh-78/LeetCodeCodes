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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        
        Stack<String> st = new Stack<String>();
        String ans;
        
        
        int i = 0;
        
        while(i<post_exp.length())
        {
            String temp="";
            if(isOp(post_exp.charAt(i)))
            {
                String t2 = st.pop();
                temp+= post_exp.charAt(i) + st.pop()+t2;
                st.push(temp);
            }
            else
            {
                temp +=post_exp.charAt(i);
                st.push(temp);
            }
            i++;
        }
        
        return st.pop();
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
