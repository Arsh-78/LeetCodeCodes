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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character,Integer> mp=new HashMap<>();
        int k =pat.length();
        for(int i=0;i<pat.length();i++)
        {
            mp.put(pat.charAt(i),mp.getOrDefault(pat.charAt(i),0)+1);
        }
        int count=mp.size();
        int start=0;
        int end=0;
        int ans=0;
        
        while(end<txt.length())
        {
            if(end-start + 1 <k)
            {
                if(mp.containsKey(txt.charAt(end)))
                {
                    mp.put(txt.charAt(end),mp.get(txt.charAt(end))-1);
                    if(mp.get(txt.charAt(end))==0)
                    {
                        count--;
                    }
                }
                end++;
            }
            else if(end-start+1==k)
            {
                if(mp.containsKey(txt.charAt(end)))
                {
                    mp.put(txt.charAt(end),mp.get(txt.charAt(end))-1);
                    if(mp.get(txt.charAt(end))==0)
                    {
                        count--;
                    }
                    
                }
                if(count==0)
                {
                    ans++;
                }
                if(mp.containsKey(txt.charAt(start)))
                    {    
                        if(mp.get(txt.charAt(start))==0)
                        {
                            count++;
                        }
                        
                        mp.put(txt.charAt(start),mp.get(txt.charAt(start))+1);
                    
                    }
                start++;
                end++;
            }
            else
            {
                end++;
            }
        }
        
        return ans;
    }
}