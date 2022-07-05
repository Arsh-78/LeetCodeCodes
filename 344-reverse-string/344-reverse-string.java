class Solution {
    public void reverseString(char[] s) {
        
        char ch=s[0];
        revRec(s,0,s.length-1,ch);
        
    }
    
    public void revRec(char[] s,int start ,int end,char ch)
    {
        if(start>=end)
        {
            return;
        }
        
        ch = s[start];
        s[start]=s[end];
        s[end]=ch;
        start++;
        end--;
        revRec(s,start,end,ch);
    }
    
 
}