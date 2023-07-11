class Solution {
    public int lengthOfLongestSubstring(String s) {

     int start =0;
     int end=0;
     int ans=0;
     int cur=0;
     int n = s.length();
     HashMap<Character,Integer> mp = new HashMap();

     while(end<n && start<=end)
     {
         if(!mp.containsKey(s.charAt(end)))
         {
             mp.put(s.charAt(end),1);
             end++;
             cur++;
            ans = Math.max(ans,cur);
         }
         else if(mp.get(s.charAt(end))==0)
         {
             mp.put(s.charAt(end),1);
             cur++;
             ans = Math.max(ans,cur);
             end++;
         }
         else
         {
             if(mp.containsKey(s.charAt(start)))
             {
                 mp.put(s.charAt(start),0);
                 cur--;
                 
             }
             start++;
         }

     }
     return ans;
    }
}