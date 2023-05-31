//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        
        
        List<String> fans = new ArrayList<String>();
        fans.add("");
    
        for(int i=0;i<s.length();i++)
        {
            //
            int n =fans.size();
            for(int j=0 ;j<n;j++)
            {
                
                fans.add(fans.get(j)+s.charAt(i));
            }

        }
        fans.remove(0);
        Collections.sort(fans);
        return fans;
   
    }
}