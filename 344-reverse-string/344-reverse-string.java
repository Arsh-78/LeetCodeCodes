class Solution {
    public void reverseString(char[] s) {
        
        System.out.println(revRecursion(s,0,s.length-1));
    }
    
    public char[] revRecursion(char[] s,int start ,int end)
    {
        if(start==end || start > end)
        {
            return s;
        }
        
        char temp  =  s[start];
        s[start] = s[end];
        s[end]=temp;
        
        return revRecursion(s,++start,--end);
        }
}