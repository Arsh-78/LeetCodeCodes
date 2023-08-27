class Solution {
    public int numberOfSubstrings(String s) {
        int[] a = new int[3];
        int j=0;
        int ans =0;
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-'a']++;
            
            while(a[0] >0 && a[1]>0 && a[2]>0)
            {
                ans+= s.length()-i;
                a[s.charAt(j)-'a']--;
                j++;
            }
            
        }
        return ans;
    }
}