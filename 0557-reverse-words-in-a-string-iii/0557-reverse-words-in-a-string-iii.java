class Solution {
    public String reverseWords(String s) {
        String ans="";
        int cur=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                ans += helper(s.substring(cur,i)) +' ';
                cur=i+1;
            }

        }
        ans += helper(s.substring(cur));
        return ans;
        
    }
    public String helper(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();      
     
    }
}