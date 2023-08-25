class Solution {
    public int characterReplacement(String s, int k) {
        
        int start =0 ;
        int end=0;
        int maxL=0;
        int[] charF = new int[26];
        int largest=0;
        
        while(end<s.length())
        {
            charF[s.charAt(end)-'A']++;
            largest = Math.max(largest, charF[s.charAt(end)-'A']);
            
            if(end-start+ 1 -largest >k)
            {
                charF[s.charAt(start)-'A']--;
                start++;
            }
            
            maxL=Math.max(maxL,end-start+ 1 );
            end++;
        }
        
        return maxL;
    }
}