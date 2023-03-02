class Solution {
    public int myAtoi(String s) {
        int i=0;
        int len =s.length();
        if(len==0)
        {
            return 0;
        }
        int sign=1;
        int result=0;
        while(i<len && s.charAt(i)==' ' )
        {
            i++;
        }
        if(i>=len)
        {
            return 0;
        }
        if(s.charAt(i)=='-')
        {
            sign=-1;
            i++;
        }
        else if(s.charAt(i)=='+')
        {
            i++;
        }
        
        while(i<len && (s.charAt(i)>='0' && s.charAt(i)<='9'))
        {
            if(result>Integer.MAX_VALUE/10)
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            else if(result==Integer.MAX_VALUE/10 && s.charAt(i)-48>7)
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            else
            {
                result=result*10+(s.charAt(i)-48);
                i++;
            }
        }
        
        return result*sign;
    }
}