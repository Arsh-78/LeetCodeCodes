class Solution {
    public int longestPalindrome(String s) {
        
        int[] arr = new int[52];
        Arrays.fill(arr,0);
        
        for(int i=0 ;i<s.length();i++)
        {
            if(s.charAt(i)-'a' >=0)
                arr[s.charAt(i)-'a']++;
            else
                arr[s.charAt(i)-'a' + 58]++;
                
        }
        
        int odd=0;
        int l=0;
        for(int i=0;i<52;i++)
        {
            if(arr[i]==0)
            {
                continue;
            }
            else if(arr[i] %2 !=0)
            {
                l = l +arr[i]-1;
                odd=1;
            }
            else
            {
                l+=arr[i];
            }
        }
        
        return l+odd ;
    }
}